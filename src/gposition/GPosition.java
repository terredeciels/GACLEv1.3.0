package gposition;

import chesspresso.*;
import chesspresso.position.Position;
import gposition.generateur.*;
import static gposition.generateur.ICodage.*;
import java.util.*;
import org.apache.commons.collections.iterators.*;

public class GPosition {

    private final int NB_CELLULES = 144;
    private final int PAS_DE_CASE = -1;
    private final int[] CASES = {
        26, 27, 28, 29, 30, 31, 32, 33, 38, 39, 40, 41, 42, 43, 44, 45, 50, 51, 52, 53, 54, 55, 56, 57, 62, 63, 64, 65,
        66, 67, 68, 69, 74, 75, 76, 77, 78, 79, 80, 81, 86, 87, 88, 89, 90, 91, 92, 93, 98, 99, 100, 101, 102, 103, 104,
        105, 110, 111, 112, 113, 114, 115, 116, 117
    };
    private final int BLANC = -1;
    private final int NOIR = 1;
    private final int OUT = 9;
    private String fen;
    private final int[] etats;
    private int trait;
    private ArrayList<GCoups> coupsValides;
    private CPosition cp_position;
    private boolean droitPetitRoqueBlanc;
    private boolean droitGrandRoqueNoir;
    private boolean droitGrandRoqueBlanc;
    private boolean droitPetitRoqueNoir;
    private int caseEP;
    
    private int num_coups;
    private GCoups gcoups;
    private short[] cp_coups;
     

    public GPosition() {
        etats = new int[NB_CELLULES];
        String fen_initiale = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        this.fen = fen_initiale;
        init(fen_initiale);
       // generateur = new Generateur(this);
    }

    public GPosition(String f) {
        etats = new int[NB_CELLULES];
        init(f);
//        generateur = new Generateur(this);
    }

    public final void init(final String fen) throws IllegalArgumentException {
        this.fen = fen;
        cp_position = new CPosition(fen);
        for (int caseO = 0; caseO < NB_CELLULES; caseO++) {
            etats[caseO] = OUT;
        }
        ArrayIterator itetats = new ArrayIterator(cp_position.getEtats());
        int indice = 0;
        while (itetats.hasNext()) {
            Integer e = (Integer) itetats.next();
            etats[CASES[indice]] = e;
            indice++;
        }
        if (cp_position.getTrait() == Chess.WHITE) {
            trait = BLANC;
        } else {
            trait = NOIR;
        }
        droitPetitRoqueBlanc = cp_position.getDroitPetitRoqueBlanc();
        droitPetitRoqueNoir = cp_position.getDroitPetitRoqueNoir();
        droitGrandRoqueBlanc = cp_position.getDroitGrandRoqueBlanc();
        droitGrandRoqueNoir = cp_position.getDroitGrandRoqueNoir();
        if (cp_position.getCaseEP() == PAS_DE_CASE) {
            caseEP = -1;
        } else {
            caseEP = CASES[cp_position.getCaseEP()];
        }
    }

    public Position getPosition() {
        return cp_position.getPosition();
    }

    public void setCoupsValides(ArrayList<GCoups> coupsValides) {
        this.coupsValides = coupsValides;
    }

    public int[] getEtats() {
        return etats;
    }

    public int getTrait() {
        return trait;
    }

    public void setTrait(int trait) {
        this.trait = trait;
    }

    public int getCaseEP() {
        return caseEP;
    }

    public ArrayList<GCoups> getCoupsValides() {
        return coupsValides;
    }

    public boolean getDroitPetitRoqueBlanc() {
        return droitPetitRoqueBlanc;
    }

    public boolean getDroitPetitRoqueNoir() {
        return droitPetitRoqueNoir;
    }

    public boolean getDroitGrandRoqueNoir() {
        return droitGrandRoqueNoir;
    }

    public boolean getDroitGrandRoqueBlanc() {
        return droitGrandRoqueBlanc;
    }

    public ArrayList<String> toStringListGCoups() {
        ArrayList<String> result = new ArrayList<>();
        for (GCoups c : coupsValides) {
            result.add(GCoups.getString(c));
        }
        Collections.sort(result);
        return result;
    }

    public void setCaseEP(int caseEP) {
        this.caseEP = caseEP;
    }

    public void setGCoups(GCoups coups) {
        this.gcoups = coups;
    }

    public GCoups getGCoups() {
        return gcoups;
    }

    public GPosition copie() {
        GPosition position = new GPosition(fen);
        System.arraycopy(etats, 0, position.etats, 0, NB_CELLULES);
        return position;
    }

    public String print() {
        String str = "";
        String e_str;
        String Clr_str;
        int rg = 0;
        for (int e : etats) {
            int piecetype = Math.abs(e);
            Clr_str = piecetype == e ? "N" : "B";
            switch (piecetype) {
                case PION:
                    e_str = "P";
                    break;
                case ROI:
                    e_str = "K";
                    break;
                case VIDE:
                    e_str = " ";
                    break;
                case OUT:
                    e_str = "X";
                    break;
                default:
                    e_str = STRING_PIECE[piecetype];
                    break;
            }
            Clr_str = "X".equals(e_str) ? "X" : Clr_str;
            Clr_str = " ".equals(e_str) ? "_" : Clr_str;
            str += e_str + Clr_str + " ";
            rg++;
            if (rg == 12) {
                str += '\n';
                rg = 0;
            }
        }
        return str;
    }

    public void setNum_coups(int num_coups) {
        this.num_coups = num_coups;
    }

    public int getNum_coups() {
        return num_coups;
    }

    public void setCPCoups(short[] allMoves) {
        this.cp_coups = allMoves;
    }

    public short[] getCPCoups() {
        return cp_coups;
    }
//    @Override
//    public String toString() {
//        ArrayList<String> diff = getTest().getDiffStringList();
//        if (!diff.isEmpty()) {
//            return "Coups ChessPresso:" + '\n' + cp_position.toStringListCPCoups() + '\n' + "Coups GCLE:"
//                    + "\n" + toStringListGCoups() + "\n" + "Diff:" + "\n" + diff + "\n";
//        } else {
//            return "no diff" + '\n';
//        }
//    }

//    @Override
//    public String toString() {
//        return toStringListGCoups() + "";
//    }
//    @Override
//    public String toString() {
//        ArrayList<String> diff = getTest().getDiffStringList();
//        if (!diff.isEmpty()) {
//            return fen + '\n' + "Coups ChessPresso:" + "\n" + cp_position.toStringListCPCoups() + '\n' + "Coups GCLE:"
//                    + "\n" + toStringListGCoups() + "\n" + "Diff:" + "\n" + diff + "\n";
//        } else {
////            return "no diff" + '\n';
//            return "";
//        }
//    }
//    private GPositionTest getTest() {
//        GPositionTest valid = new GPositionTest();
//        ArrayList<String> lg_coups = toStringListGCoups();
//        ArrayList<String> lcp_coups = cp_position.toStringListCPCoups();
//        if (lg_coups.size() <= lcp_coups.size()) {
//            valid.setDiffStringList(getDiff(lg_coups, lcp_coups));
//        } else {
//            valid.setDiffStringList(getDiff(lcp_coups, lg_coups));
//        }
//        return valid;
//    }
//    private ArrayList<String> getDiff(ArrayList<String> L1, ArrayList<String> L2) {
//        L2.removeAll(L1);
//        return L2;
//    }
}
