package shooot.map.entity;

import shooot.map.Map;
import java.awt.Graphics;

/**
 * @author partha
 */
public abstract class StaticEntity extends Entity {

    public StaticEntity(int posX,int posY, Map m) {
        super(posX,posY, m);
    }

    @Override
    public void renderHitBox(Graphics g, double x, double y) {
        double posX = this.posX - x;
        double posY = this.posY - y;

        g.drawRect((int)posX, (int)posY, this.getWidth(), this.getHeight());

        HitBox[] hitbox = currentSprite.getHitBox();

        for (int i=0;i<hitbox.length;i++) {
            hitbox[i].draw(g, posX, posY);
        }
    }

}
