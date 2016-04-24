package ggame;

import chesspresso.Chess;
import chesspresso.move.IllegalMoveException;
import chesspresso.position.Position;
import ggame.ia.IA_1;
import ggame.ia.IA;
import com.googlecode.jctree.NodeNotFoundException;
import ggame.ia.IIA;
import ggame.movetree.GMoveTree;
import gposition.GCoups;
import gposition.GPosition;
import gposition.generateur.Generateur;
import gposition.generateur.ICodage;
import static gposition.generateur.ICodage.*;
import static gtools.GTools.toStringListCPCoups;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GGame extends Generateur {

    private static final long serialVersionUID = 1L;

    private int ordi_couleur;
    private final int hum_couleur;
    private final int profondeur;
    private final boolean mode_arbre;
    private final boolean mode_auto;
    private final boolean mode_contre_chesspresso;
    private GCoups gcoups;
    private short coupsCP;
//    private Game cpgame;
    private final ArrayList<GPosition> partie;
    private int num_coups;

    public GGame(GPosition g_position) throws NodeNotFoundException {
        super(g_position);
        partie = new ArrayList<>();
        ordi_couleur = BLANC;
        hum_couleur = NOIR;
        profondeur = 1;
        mode_arbre = false;
        mode_auto = true;
        mode_contre_chesspresso = false;
        if (!mode_contre_chesspresso) {
            if (!mode_auto) {
                play_computer();
            } else {
                play_auto();
            }
        } else {
//            ordi_couleur = BLANC;
//            GameModel gameModel;
//            cpgame = new Game(gameModel);//chesspresso game
//            play_with_chesspresso();
        }
    }

    public GPosition executeMove(GPosition gposition, GCoups coups, int couleur) {
        int caseO = coups.getCaseO();
        int caseX = coups.getCaseX();
        gposition.setCaseEP(-1);
        if (coups.getPiece() == PION && Math.abs(caseX - caseO) == 24) {// avance de 2 cases
            int caseEP = couleur == NOIR ? caseX + 12 : caseX - 12;
            gposition.setCaseEP(caseEP);
        }
        if (coups.getTypeDeCoups()
                == ICodage.TYPE_DE_COUPS.Deplacement
                || coups.getTypeDeCoups() == ICodage.TYPE_DE_COUPS.Prise) {
            gposition.getEtats()[caseX] = gposition.getEtats()[caseO];
            gposition.getEtats()[caseO] = VIDE;
        } else if (coups.getTypeDeCoups()
                == ICodage.TYPE_DE_COUPS.EnPassant) {
            // caseX == caseEP
            gposition.getEtats()[caseX] = gposition.getEtats()[caseO];
            gposition.getEtats()[caseO] = VIDE;
            if (couleur == BLANC) {
                gposition.getEtats()[caseX + sud] = VIDE;
            } else if (couleur == NOIR) {
                gposition.getEtats()[caseX + nord] = VIDE;
            }
        } else if (coups.getTypeDeCoups() == ICodage.TYPE_DE_COUPS.Promotion) {
            gposition.getEtats()[caseX] = coups.getPiecePromotion();
            gposition.getEtats()[caseO] = VIDE;

        } else if (coups.getTypeDeCoups() == ICodage.TYPE_DE_COUPS.Roque) {

        }
        return gposition;
    }

    public final void play_auto() throws NodeNotFoundException {
        g_position = play_computer();
        ordi_couleur = -ordi_couleur;
    }

    private void play_with_chesspresso() {
        // GACLE a les Blancs
    }

    public final GPosition play_computer() throws NodeNotFoundException {
        if (mode_arbre) {
            //arbre niveau n
            g_position.setTrait(ordi_couleur);
            GMoveTree gMoveTree = new GMoveTree(profondeur);
            gMoveTree.initializeTree(g_position, ordi_couleur);
            IIA ia = new IA();
            GCoups coups = ia.evaluate(gMoveTree.getT(), ordi_couleur);
            g_position = executeMove(g_position, coups, ordi_couleur);

            return g_position;
        } else {
            g_position.setTrait(ordi_couleur);
            Generateur gen_pos = new Generateur(g_position);
            ArrayList<GCoups> coupsvalides = gen_pos.getCoups();
            g_position.setCoupsValides(coupsvalides);////

            IIA ia1 = new IA_1();
            gcoups = ia1.evaluate(coupsvalides, ordi_couleur);
            g_position = executeMove(g_position, gcoups, ordi_couleur);
            g_position.setGCoups(gcoups);
            g_position.setNum_coups(num_coups++);
            partie.add(g_position.copie()); // !! copie() necessaire

            //ChessPresso
            Position position = g_position.getPosition();
            int cp_ordi_couleur = ordi_couleur == BLANC ? Chess.WHITE : Chess.BLACK;
            position.setToPlay(cp_ordi_couleur);
            short[] allMoves = position.getAllMoves();
            String gcoups_str = GCoups.getString(gcoups);
            int index = toStringListCPCoups(allMoves).indexOf(gcoups_str);
            coupsCP = position.getAllMoves()[index];

            g_position.setCPCoups(allMoves);
            try {
                position.doMove(coupsCP);
            } catch (IllegalMoveException ex) {
                Logger.getLogger(GGame.class.getName()).log(Level.SEVERE, null, ex);
            }

            return g_position;
        }
    }

    public boolean play_human(int caseO, int caseX) {
        //roque a part
        //promo auto dame
        g_position.setTrait(hum_couleur);
        Generateur gen_pos = new Generateur(g_position);
        ArrayList<GCoups> coupsvalides = gen_pos.getCoups();
        g_position.setCoupsValides(coupsvalides);
        for (GCoups coups : coupsvalides) {
            int caseO1 = coups.getCaseO();
            int caseX1 = coups.getCaseX();
            if (caseO1 == caseO && caseX1 == caseX) {
                g_position = executeMove(g_position, coups, hum_couleur);
                return true;
            }
        }
        return false;
    }

    public GPosition getG_position() {
        return g_position;
    }

    public boolean isMode_auto() {
        return mode_auto;
    }

    public GCoups getGcoups() {
        return gcoups;
    }

    public short getCoupsCP() {
        return coupsCP;
    }

    public ArrayList<GPosition> getPartie() {
        return partie;
    }

    public void setG_position(GPosition g_position) {
        this.g_position = g_position;
    }


}
