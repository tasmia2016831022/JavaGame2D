package shooot.game;

import java.util.TimerTask;

/**
 * @author partha
 */
public class GameUpdater extends TimerTask {

    private Game g;
    private boolean running;

    /**
     * @param game
     */
    public GameUpdater(Game game) {
        g = game;
        running = false;
    }

    public void run() {
        if (!running) {
            running = true;
            g.updateGame();
            running = false;
        }
    }

}
