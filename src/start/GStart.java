package start;

import com.googlecode.jctree.NodeNotFoundException;
import ggame.GGame;
import ggame.gui.ChessGui;
import gposition.GPosition;
import static gposition.generateur.ICodage.fen_initiale;

public class GStart {

    public static void main(String[] args) throws NodeNotFoundException {
        start();
    }

    public static void start() throws NodeNotFoundException {
        GPosition POS_INIT = new GPosition(fen_initiale);
        GGame ggame = new GGame(POS_INIT);
        ChessGui chessGui = new ChessGui(ggame);
        chessGui.setGuiPosition(POS_INIT);
    }
}
