package shooot.game;
import java.io.BufferedInputStream;
import javazoom.jl.player.Player;
/**
 * @author partha
 */
public class SoundPlay {

    private Player player;
    private String filename;
    public SoundPlay(String filename) {
        this.filename = filename;

    }
    public void close() {
        if (player != null) {
            player.close();
        }
    }

    public void play() {
        try {
            BufferedInputStream bis = new BufferedInputStream(this.getClass().getResourceAsStream(filename));
            player = new Player(bis);
        } catch (Exception e) {
            System.out.println("Problem playing file ");
            System.out.println(e);
        }

        new Thread() {

            @Override
            public void run() {
                try {
                    player.play();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
    }
    public void repeat() {
        if (player.isComplete()) {
            play();
        }
    }
}

