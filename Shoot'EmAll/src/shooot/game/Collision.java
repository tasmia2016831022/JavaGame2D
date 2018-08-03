package shooot.game;

import shooot.map.entity.Entity;

/**
 *  contains information about  collision between two entities
 * uses public fields and contains which side of the entity it collides with
 * delta contains how big the overlap is in each direction as seen from the  colliding entity.
 * 
 * @author partha
 */
public class Collision {

    public boolean collided;
    
    public boolean crossedLeft;

    public boolean crossedRight;

    public boolean crossedTop;

    public boolean crossedBottom;
    
    public Entity collidingEntity;

    public Entity collidedWith;

    public double deltaLeft;

    public double deltaRight;

    public double deltaTop;

    public double deltaBottom;

    public Collision() {
        collided = false;

        crossedLeft = false;
        crossedRight = false;
        crossedTop = false;
        crossedBottom = false;

        collidingEntity = null;
        collidedWith = null;

        deltaLeft = 0;
        deltaRight = 0;
        deltaTop = 0;
        deltaBottom = 0;
    }

    @Override
    public String toString() {

        String result = "";
        result += "Top: " + crossedTop + " " + deltaTop + '\n';
        result += "Bottom: " + crossedBottom + " " + deltaBottom + '\n';
        result += "Left: " + crossedLeft + " " + deltaLeft + '\n';
        result += "Right: " + crossedRight + " " + deltaRight + '\n';
        result += "--------------------------------" + '\n';
        return result;
    }

}
