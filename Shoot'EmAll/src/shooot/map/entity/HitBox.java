package shooot.map.entity;

import shooot.game.Collision;
import java.awt.Graphics;

/**
 * @author partha
 */
public class HitBox {

    private int offsetX;
    private int offsetY;

    private int width;
    private int height;

    public HitBox(int offX, int offY, int width, int height) {
        offsetX = offX;
        offsetY = offY;

        this.width = width;
        this.height = height;
    }

    public Collision collidesWith(HitBox box, double ownPosX, double ownPosY, 
            double ownPPosX, double ownPPosY, double otherPosX, double otherPosY,
            double otherPPosX, double otherPPosY) {

        Collision c = new Collision();

        double left1, left2;
        double right1, right2;
        double top1, top2;
        double bottom1, bottom2;

        if (ownPosX > ownPPosX) {
            left1 = ownPPosX + offsetX;
            right1 = ownPosX + offsetX + width;
        } else {
            left1 = ownPosX + offsetX;
            right1 = ownPPosX + offsetX + width;
        }

        if (otherPosX > otherPPosX) {
            left2 = otherPPosX + box.getOffsetX();
            right2 = otherPosX + box.getOffsetX() + box.getWidth();
        } else {
            left2 = otherPosX + box.getOffsetX();
            right2 = otherPPosX + box.getOffsetX() + box.getWidth();
        }

        if (ownPosY > ownPPosY) {
            top1 = ownPPosY + offsetY;
            bottom1 = ownPosY + offsetY + height;
        } else {
            top1 = ownPosY + offsetY;
            bottom1 = ownPPosY + offsetY + height;
        }

        if (otherPosY > otherPPosY) {
            top2 = otherPPosY + box.getOffsetY();
            bottom2 = otherPosY + box.getOffsetY() + box.getHeight();
        } else {
            top2 = otherPosY + box.getOffsetY();
            bottom2 = otherPPosY + box.getOffsetY() + box.getHeight();
        }

        if (bottom1 < top2) {
            return c;
        }
        if (top1 > bottom2) {
            return c;
        }

        if (right1 < left2) {
            return c;
        }
        if (left1 > right2) {
            return c;
        }

        c.collided = true;

        if (right2 > left1 && right2 < right1) {
            c.crossedLeft = true;
        }
        if (left2 < right1 && left2 > left1) {
            c.crossedRight = true;
        }

        if (bottom2 > top1 && bottom2 < bottom1) {
            c.crossedTop = true;
        }
        if (top2 < bottom1 && top2 > top1) {
            c.crossedBottom = true;
        }

        c.deltaRight = right1 - left2;
        c.deltaBottom = bottom1 - top2;
        c.deltaTop = bottom2 - top1;
        c.deltaLeft = right2 - left1;

        return c;
    }
    public void draw (Graphics g, double posX, double posY) {
        g.drawRect((int)posX + offsetX, (int) posY + offsetY, width, height);
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
