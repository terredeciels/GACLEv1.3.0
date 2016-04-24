package ggame.movetree;

import com.googlecode.jctree.ArrayListTree;
import com.googlecode.jctree.NodeNotFoundException;
import com.googlecode.jctree.Tree;
import gposition.GCoups;
import gposition.GPosition;
import gposition.generateur.Generateur;
import gposition.generateur.ICodage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GMoveTree implements ICodage {

    private Tree<GPosition> T;
    private final int profondeur;

    public GMoveTree(int profondeur) {
        this.profondeur = profondeur;
    }

    public void printTree() {
        Iterator<GPosition> it = T.iterator();
        while (it.hasNext()) {
            GPosition gp = it.next();
            System.out.println(gp.print());
        }
    }

    public Tree<GPosition> getT() {
        return T;
    }

    @SuppressWarnings("deprecation")
    private Tree<GPosition> buildTree(Tree<GPosition> t, int niveau, int couleur) throws NodeNotFoundException {
        Collection<GPosition> leaves = t.leaves();
        Iterator<GPosition> it = leaves.iterator(); // feuille arbre en cours
        while (it.hasNext()) {
            GPosition pos = it.next();
            //ajoute  une liste de coups valides à chaque feuille
            ArrayList<GPosition> vgposlistpos = validGPositionList(pos, niveau, couleur);
            t.addAll(pos, vgposlistpos);
        }
        if (niveau < profondeur) {
            niveau += 1;
            couleur = couleur == BLANC ? NOIR : BLANC;
            return buildTree(t, niveau, couleur);
        } else {
            return t;
        }
    }

    public void initializeTree(GPosition g_position, int couleur) throws NodeNotFoundException {
        T = new ArrayListTree<>();
        T.add(g_position); // level=0 ? null ? pos init
        //       new GPosition(game.getBoard(), null, 0)
        T = buildTree(T, 0, couleur);
    }

    private ArrayList<GPosition> validGPositionList(GPosition pos, int niveau, int couleur) {
//        this.color = color;
        Generateur gen_pos = new Generateur(pos);
        ArrayList<GCoups> coupsvalides = gen_pos.getCoups();
        pos.setCoupsValides(coupsvalides);

        ArrayList<GPosition> posmovelist = new ArrayList<>();

        for (GCoups coups : coupsvalides) {
            GPosition gp = simuleMove(pos, coups, couleur);// niveau ?
            gp.setTrait(-couleur);

            gp.setGCoups(coups);

            posmovelist.add(gp);
        }
        return posmovelist;
    }

    private GPosition simuleMove(GPosition gposition, GCoups coups, int couleur) {

        GPosition gpositionSimul = gposition.copie();

        int caseO = coups.getCaseO();
        int caseX = coups.getCaseX();
        gpositionSimul.setCaseEP(-1);
        if (coups.getPiece() == PION && Math.abs(caseX - caseO) == 24) {// avance de 2 cases
            int caseEP = couleur == NOIR ? caseX + 12 : caseX - 12;
            gpositionSimul.setCaseEP(caseEP);
        }
        if (coups.getTypeDeCoups()
                == ICodage.TYPE_DE_COUPS.Deplacement
                || coups.getTypeDeCoups() == ICodage.TYPE_DE_COUPS.Prise) {
            gpositionSimul.getEtats()[caseX] = gpositionSimul.getEtats()[caseO];
            gpositionSimul.getEtats()[caseO] = VIDE;
        } else if (coups.getTypeDeCoups()
                == ICodage.TYPE_DE_COUPS.EnPassant) {
            // caseX == caseEP
            gpositionSimul.getEtats()[caseX] = gpositionSimul.getEtats()[caseO];
            gpositionSimul.getEtats()[caseO] = VIDE;
            if (couleur == BLANC) {
                gpositionSimul.getEtats()[caseX + sud] = VIDE;
            } else if (couleur == NOIR) {
                gpositionSimul.getEtats()[caseX + nord] = VIDE;
            }
        } else if (coups.getTypeDeCoups() == ICodage.TYPE_DE_COUPS.Promotion) {
            gpositionSimul.getEtats()[caseX] = coups.getPiecePromotion();
            gpositionSimul.getEtats()[caseO] = VIDE;

        } else if (coups.getTypeDeCoups() == ICodage.TYPE_DE_COUPS.Roque) {

        }

        return gpositionSimul;
    }
}
