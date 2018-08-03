package shooot.map.entity;

import shooot.game.Collision;
import shooot.map.Map;

/**
 * @author partha
 */
public abstract class MovingEntity extends Entity {

    protected double newPosX;

    protected double newPosY;

    public MovingEntity(double posX, double posY, Map map) {
        super(posX , posY, map);
        this.newPosX = posX;
        this.newPosY = posY;
    }
    public abstract void collided(Collision c);

    public abstract void calculateMovement();
    public void move() {
        this.pposX = this.posX;
        this.pposY = this.posY;
        this.posX = newPosX;
        this.posY = newPosY;
    }

    public abstract boolean facingRight();

    public double getNewXPosition() {
        return newPosX;
    }

    public double getNewYPosition() {
        return newPosY;
    }

}
