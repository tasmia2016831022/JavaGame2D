package shooot.map.entity;

import shooot.game.Collision;
import shooot.game.Sprite;
import shooot.map.Map;
import java.awt.Graphics;

/**
 * @author partha
 */
public abstract class Entity {

    protected double posX;

    protected double posY;

    protected double pposX;

    protected double pposY;
   
    protected Sprite currentSprite;

    protected Map mapReference;

    public Entity (double posX,double posY, Map map) {
        this.posX = posX;
        this.posY = posY;
        this.pposX = posX;
        this.pposY = posY;
        mapReference = map;
    }

    /*
     * Rendering the object
     *
     * @param g The graphic object the entity is to be drawn on
     * @param delta An int specifying the number of milliseconds since last gameupdate
     * @param x The X coordinate of the render position. Usually specified from the current player
     * @param y The Y coordinate of the render position. Usually fixed
     */
    public void render(Graphics g, int delta, double x, double y) {
        double coeff = (double)delta/16;

        double posX = this.posX - x;
        double posY = this.posY - y;
        double pposX = this.pposX - x;
        double pposY = this.pposY - y;

        //Smoothing out frame drawings
        currentSprite.draw(g, (int)Math.round(posX+(posX-pposX)*coeff), (int)Math.round(posY+(posY-pposY)*coeff));
    }

    /**
     * Renders the hitbox of the entity, for debugging purposes
     *
     * @param g the graphics object to be drawn on
     * @param x x position of the hitbox
     * @param y y position of the hitbox
     */
    public abstract void renderHitBox(Graphics g, double x, double y);

    /**
     * Returns the X position of the entity
     *
     * @return X position of the entity
     */
    public double getXRenderPosition() {
        return getXPosition();
    }
    public double getYRenderPosition() {
        return getYPosition();
    }
    public double getXPosition() {
        return posX;
    }
    public double getYPosition() {
        return posY;
    }
     public int getWidth() {
         return currentSprite.getWidth();
     }
     public int getHeight() {
         return currentSprite.getHeight();
     }
     public HitBox[] getHitbox() {
         return currentSprite.getHitBox();
     }
    public Collision collision(Entity toCheckAgainst) {
        Collision c = new Collision();

        double x = toCheckAgainst.getXPosition();;
        double y = toCheckAgainst.getYPosition();
        double px = x;
        double py = y;

        double ox = this.posX, oy = this.posY, opx = ox, opy = oy;

        if (toCheckAgainst instanceof MovingEntity) {
            x = ((MovingEntity)toCheckAgainst).getNewXPosition();
            y = ((MovingEntity)toCheckAgainst).getNewYPosition();
            px = ((MovingEntity)toCheckAgainst).getXPosition();
            py = ((MovingEntity)toCheckAgainst).getYPosition();
        }

        if (this instanceof MovingEntity) {
            ox = ((MovingEntity)this).getNewXPosition();
            oy = ((MovingEntity)this).getNewYPosition();
            opx = this.posX;
            opy = this.posY;
        }

        double left1, left2;
        double right1, right2;
        double top1, top2;
        double bottom1, bottom2;

        left1 = ox;
        left2 = x;
        right1 = ox + this.getWidth();
        right2 = x + toCheckAgainst.getWidth();
        top1 = oy;
        top2 = y;
        bottom1 = oy + this.getHeight();
        bottom2 = y + toCheckAgainst.getHeight();

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

        Collision temp;

        c.collidedWith = this;
        c.collidingEntity = toCheckAgainst;

        for(HitBox h:this.getHitbox()) {
            for(HitBox k:toCheckAgainst.getHitbox()) {
                temp = h.collidesWith(k, ox, oy, opx, opy, x, y, px, py);
                if (temp.collided) {
                    c.collided = true;

                    c.crossedBottom = (c.crossedBottom || temp.crossedBottom);
                    c.crossedTop = (c.crossedTop || temp.crossedTop);
                    c.crossedLeft = (c.crossedLeft || temp.crossedLeft);
                    c.crossedRight = (c.crossedRight || temp.crossedRight);

                    c.deltaBottom = Math.max(temp.deltaBottom, c.deltaBottom);
                    c.deltaTop = Math.max(temp.deltaTop, c.deltaTop);
                    c.deltaLeft = Math.max(temp.deltaLeft, c.deltaLeft);
                    c.deltaRight = Math.max(temp.deltaRight, c.deltaRight);
                }

            }
        }

        return c;
    }
}