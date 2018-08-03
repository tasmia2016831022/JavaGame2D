package shooot.map;

import shooot.game.Collision;
import shooot.map.entity.MovingEntity;
import shooot.map.entity.StaticEntity;
import java.awt.Graphics;
import java.util.HashMap;

/**
 * @author partha
 */
public class Container {

    private int width;
    private HashMap<Long, StaticEntity[]> map;
    public Container(int width) {
        this.width = width;
        map = new HashMap<Long, StaticEntity[]>(100);
    }
    public void add(StaticEntity w) {

        long x = (int)Math.round(w.getXPosition());
        long reminder = x % width;
        long ref = x - reminder;
        
        if (map.containsKey(ref)) {
            StaticEntity[] cur = map.get(ref);
            StaticEntity[] temp = new StaticEntity[cur.length + 1];

            System.arraycopy(cur, 0, temp, 0, cur.length);
            temp[temp.length-1] = w;
            map.put(ref, temp);
        } else {
            map.put(ref, new StaticEntity[]{w});
        }
    }
    public void renderAll(Graphics g, int delta, double renderXPosition, double renderYPosition) {

        long x = (int)Math.round(renderXPosition);
        long reminder = x % width;
        long ref = x - reminder;

        while (ref > renderXPosition - width) {
            ref -= width;
        }

        StaticEntity[] temp = null;

        while (ref < renderXPosition + 800 + width) {
            temp = map.get(ref);
            if (temp != null) {
                for(int i=0;i<temp.length;i++) {
                    temp[i].render(g, delta, renderXPosition, renderYPosition);
                }
            }
            ref += width;
        }

    }
    public void checkCollision (MovingEntity e) {

        long x = (int)Math.round(e.getXPosition());
        long reminder = x % width;
        long ref = x - reminder;
        
        StaticEntity[] temp = null;
        Collision c = null;

        while (ref < e.getXPosition() + e.getWidth()) {
            temp = map.get(ref);
            if (temp != null) {
                for(int i=0;i<temp.length;i++) {
                    c = temp[i].collision(e);
                    if (c.collided) {
                        e.collided(c);
                    }
                }
            }
            ref += width;
        }
    }
    public int size() {
        return map.size();
    }

}
