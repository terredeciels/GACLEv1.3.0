package ggame.ia;

import com.googlecode.jctree.Tree;
import gposition.GCoups;
import gposition.GPosition;
import java.util.ArrayList;

public interface IIA {

    GCoups evaluate(Tree<GPosition> T, int couleur);

    GCoups evaluate(ArrayList<GCoups> coupsvalides, int couleur);

}
