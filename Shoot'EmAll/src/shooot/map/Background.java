package shooot.map;

import shooot.game.ImageStore;
import java.awt.Graphics;
import java.awt.Image;

/**
 * @author partha
 */
public class Background {

    private Image bgImage;
    private int repeat = 0;
    private int repeatPos = 0;
    private int imageSize = 2000;
    private double relativeDistance = 0.5;
    public Background(String ref, double scale) {
        ImageStore s = ImageStore.get();
        repeat = 0;
        repeatPos = 0;
        bgImage = s.getImage(ref, false, scale);
        imageSize = bgImage.getWidth(null);
    }
    public void render(Graphics g, double x, double y) {
        repeat = ((int) ((x * relativeDistance)) / imageSize);
        if (x*relativeDistance < 0) { repeat += -1; }
        repeatPos = repeat*imageSize;
        if ((x*relativeDistance) < imageSize+repeatPos || (x*relativeDistance) == imageSize+repeatPos) {
            g.drawImage(bgImage, 0 - (int) (x * relativeDistance)+repeatPos, -80 - (int) (y * relativeDistance/10)-100, null);
        }
        if ((x*relativeDistance+800) > imageSize+repeatPos) {
            g.drawImage(bgImage, 0 - (int) (x * relativeDistance)+(repeatPos)+imageSize, -80 - (int) (y * relativeDistance/10)-100, null);
        }

    }
}
