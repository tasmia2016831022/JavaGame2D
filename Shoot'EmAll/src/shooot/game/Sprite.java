package shooot.game;

import shooot.map.entity.HitBox;
import java.awt.Graphics;
import java.awt.Image;

/**
 * @author partha
 */
public class Sprite {
	private Image[] image;

        private int pos;
        private HitBox[] hitbox;
        private int offset;
	public Sprite(String[] urls) {

                ImageStore s = ImageStore.get();

                pos = 0;

                Image[] images = new Image[urls.length];
                
                for (int i=0;i<urls.length;i++) {
                    images[i] = s.get(urls[i]);
                }

		this.image = images;

                hitbox = new HitBox[]{new HitBox(0, 0, image[0].getWidth(null), image[0].getHeight(null))};

                offset = (int)Math.round(calculateOffset(hitbox)*1.5);
	}
	 
	public Sprite(String[] urls, boolean flip, HitBox[] h) {

            ImageStore s = ImageStore.get();

            pos = 0;

            Image[] images = new Image[urls.length];

            for (int i=0;i<urls.length;i++) {
                if (flip) {
                    images[i] = s.getFlipped(urls[i]);
                } else {
                    images[i] = s.get(urls[i]);
                }
            }

            this.image = images;

            if (flip) {
                hitbox = flipHitBox(h);
            } else {
                hitbox = h;
            }

            offset = calculateOffset(hitbox);
	}
	public int getWidth() {
		return image[0].getWidth(null);
	}
	public int getHeight() {
		return image[0].getHeight(null);
	}
	public synchronized void draw(Graphics g,int x,int y) {
            g.drawImage(image[pos],x,y,null);
        
	}
        public synchronized void nextImage() {
            if (pos < image.length-1) {
                pos++;
            } else {
                pos = 0;
            }
        }

        public void resetImage() {
            pos = 0;
        }
        public HitBox[] getHitBox() {
            return hitbox;
        }
        private HitBox[] flipHitBox(HitBox[] hitbox) {
            HitBox[] result = new HitBox[hitbox.length];
            for (int i=0;i<hitbox.length;i++) {
              
                result[i] = new HitBox(getWidth() - hitbox[i].getOffsetX() - hitbox[i].getWidth(), hitbox[i].getOffsetY(), hitbox[i].getWidth(), hitbox[i].getHeight());
            }
            return result;
        }
        private int calculateOffset(HitBox[] hitbox) {
            int left = 800;
            int right = 0;

            for (int i=0; i<hitbox.length; i++) {
                if (hitbox[i].getOffsetX() < left) {
                    left = hitbox[i].getOffsetX();
                }
                if (hitbox[i].getOffsetX() +  hitbox[i].getWidth() > right) {
                    right = hitbox[i].getOffsetX() +  hitbox[i].getWidth();
                }
            }
            
            return ((right + left)/2)-getWidth()/2;
        }
        public int getOffset() {
            return offset;
        }
}
