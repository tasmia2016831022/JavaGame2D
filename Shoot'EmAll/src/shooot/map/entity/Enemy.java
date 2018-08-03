package shooot.map.entity;

import shooot.map.Map;
import java.awt.Graphics;

/**
 * @author partha
 */
public abstract class Enemy extends MovingEntity {

    protected int ticker = 0;
   
    public Enemy(int posX, int posY, Map m) {
        super(posX, posY, m);
    }

    @Override
    public void renderHitBox(Graphics g, double x, double y) {

        double posX = this.posX - x;
        double posY = this.posY - y;
        HitBox[] hitbox = currentSprite.getHitBox();

        for (int i = 0; i < hitbox.length; i++) {
            hitbox[i].draw(g, posX, posY);
        }
    }

    public abstract boolean isDead();
    public abstract int getScore();

}
