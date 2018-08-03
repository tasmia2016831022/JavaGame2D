package shooot.game;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 * @author partha
 */
public class ImageStore {

    private static ImageStore single = new ImageStore();

    private HashMap<String, Image> images;
    private HashMap<String, Image> flippedImages;

    private ImageStore() {
        images = new HashMap<String, Image>();
        flippedImages = new HashMap<String, Image>();
    }

    public static ImageStore get() {
        return single;
    }

    public Image get(String ref) {

        return getImage(ref, false, 1.0);

    }

    public Image getFlipped(String ref) {
        return getImage(ref, true, 1.0);
    }

    private void fail(String message) {

        System.err.println(message);
        System.exit(0);
    }

    public Image getImage(String ref, boolean flip, double scale) {

        if (flip) {
            if (flippedImages.get(ref) != null) {
                return flippedImages.get(ref);
            }
        } else {
            if (images.get(ref) != null) {
                return images.get(ref);
            }
        }

        BufferedImage sourceImage = null;

        try {

            InputStream is = this.getClass().getResourceAsStream(ref);

            if (is == null) {
                fail("Can't find ref: " + ref);
            }

            sourceImage = ImageIO.read(is);

        } catch (IOException e) {
            fail("Failed to load: " + ref);
        }

        AffineTransform tx = null;

        if (flip) {
            tx = AffineTransform.getScaleInstance(-scale, scale);
            tx.translate(-sourceImage.getWidth(), 0);
        } else {
            tx = AffineTransform.getScaleInstance(scale, scale);
            tx.translate(0, 0);
        }
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        sourceImage = op.filter(sourceImage, null);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.TRANSLUCENT);
        image.getGraphics().drawImage(sourceImage, 0, 0, null);
        if (flip) {
            flippedImages.put(ref, image);
        } else {
            images.put(ref, image);
        }

        return image;
    }

}
