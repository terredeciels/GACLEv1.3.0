package ggame.ia;

import com.googlecode.jctree.Tree;
import gposition.GCoups;
import gposition.GPosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IA_1 implements IIA {

    private final Random randomGenerator;

    public IA_1() {
        randomGenerator = new Random();
    }

    @Override
    public GCoups evaluate(ArrayList<GCoups> coupsvalides, int couleur) {
//        Iterator<GCoups> it = coupsvalides.iterator();
//        ArrayList<GCoups> gcoupsliste = new ArrayList<>();
//        GCoups coups;
//        while (it.hasNext()) {
//            coups = it.next();
//            if (coups != null) {
//                if (coups.getPiece() == couleur) {
//                    gcoupsliste.add(coups);
//                }
//            }
//        }

        int randomInt = randomGenerator.nextInt(coupsvalides.size());
        return coupsvalides.get(randomInt);

//        return coups;
    }

    @Override
    public GCoups evaluate(Tree<GPosition> T, int couleur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
