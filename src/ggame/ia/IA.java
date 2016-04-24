package ggame.ia;

import com.googlecode.jctree.Tree;
import gposition.GCoups;
import gposition.GPosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class IA implements IIA {

    private final Random randomGenerator;

    public IA() {
        randomGenerator = new Random();
    }

    @Override
    public GCoups evaluate(Tree<GPosition> T, int couleur) {
        GCoups gcoups;
        ArrayList<GCoups> gcoupsliste = new ArrayList<>();
        Iterator<GPosition> it = T.levelOrderTraversal().iterator();
        while (it.hasNext()) {
            GPosition gp = it.next();
            if (gp.getGCoups() != null) {
                if (gp.getGCoups().getPiece() == couleur) {
                    gcoupsliste.add(gp.getGCoups());
                }
            }
        }

        int randomInt = randomGenerator.nextInt(gcoupsliste.size());
        gcoups = gcoupsliste.get(randomInt);

        return gcoups;
    }

    @Override
    public GCoups evaluate(ArrayList<GCoups> coupsvalides, int couleur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
