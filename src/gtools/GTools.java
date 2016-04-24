package gtools;

import chesspresso.move.Move;
import gposition.GCoups;
import gposition.GPosition;
import gposition.GPositionTest;
import java.util.ArrayList;
import java.util.Collections;

public class GTools {

    public static ArrayList<String> toStringListCPCoups(short[] coupsvalides_CP) {
        ArrayList<String> result = new ArrayList<>();
        for (short c : coupsvalides_CP) {
            result.add(Move.getString(c));
        }
//        Collections.sort(result); // ! Attention
        return result;
    }

    public static ArrayList<String> toStringListGCoups(ArrayList<GCoups> coupsvalides_G) {
        ArrayList<String> result = new ArrayList<>();
        for (GCoups c : coupsvalides_G) {
            result.add(GCoups.getString(c));
        }
        Collections.sort(result);
        return result;
    }

    public static GPositionTest getTest(GPosition gp) {
        GPositionTest valid = new GPositionTest();
        ArrayList<String> lg_coups = toStringListGCoups(gp.getCoupsValides());
        ArrayList<String> lcp_coups = toStringListCPCoups(gp.getCPCoups());
        if (lg_coups.size() <= lcp_coups.size()) {
            valid.setDiffStringList(getDiff(lg_coups, lcp_coups));
        } else {
            valid.setDiffStringList(getDiff(lcp_coups, lg_coups));
        }
        return valid;
    }

    private static ArrayList<String> getDiff(ArrayList<String> L1, ArrayList<String> L2) {
        L2.removeAll(L1);
        return L2;
    }
}
