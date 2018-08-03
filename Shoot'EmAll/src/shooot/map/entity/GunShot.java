package shooot.map.entity;

import shooot.game.Collision;
import shooot.game.Sprite;
import shooot.map.Map;
import java.awt.Graphics;

/**
 * @author partha
 */
public class GunShot extends MovingEntity {

    private boolean headingRight = false;
    private double distanceTravled = 0;
    private double distanceMax = 600;
    private int speed = 12;
    private Entity shotBy;

    
    public GunShot(double posX, double posY, boolean headingRight, Entity shooter, Map m) {
        super(posX, posY, m);

        HitBox[] h = new HitBox[1];
        h[0] = new HitBox(0, 0, 14, 5);

        if (headingRight) {
            currentSprite = new Sprite(new String[]{"/pics/smallbullet.png"},false,h);
        } else {
            currentSprite = new Sprite(new String[]{"/pics/smallbullet.png"},true,h);
        }
        this.headingRight = headingRight;

        shotBy = shooter;

    }

    @Override
    public void renderHitBox(Graphics g, double x, double y) {
        double renderPosX = this.posX - x;
        double renderPosY = this.posY - y;

        g.drawRect((int) renderPosX, (int) renderPosY, this.getWidth(), this.getHeight());
    }



    @Override
    public void calculateMovement() {
        if (headingRight) {
            newPosX += speed;
        } else {
            newPosX -= speed;
        }
        distanceTravled += speed;
    }

    @Override
    public boolean facingRight() {
        return headingRight;
    }

    public boolean distanceDone() {
        return (distanceTravled >= distanceMax);
    }

    @Override
    public void collided(Collision c) {
        if (!shotBy.equals(c.collidedWith) && !(c.collidedWith instanceof GunShot )) {
            distanceTravled = distanceMax+1;
        }
    }

    public Entity getShooter() {
        return shotBy;
    }

    public void remove() {
        distanceTravled = distanceMax+1;
    }

}
