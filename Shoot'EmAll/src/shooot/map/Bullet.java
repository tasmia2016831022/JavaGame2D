package shooot.map;
import shooot.map.entity.Entity;
import shooot.map.entity.GunShot;
import java.util.ArrayList;

/**
 * @author partha
 */
public class Bullet {
    private ArrayList<GunShot> shots;
    private Map m;
    public Bullet(Map m) {
        shots = new ArrayList<GunShot>();
        this.m = m;
    }

    public void update() {
        GunShot[] tempshot = new GunShot[shots.size()];
        shots.toArray(tempshot);
        for (int i = 0; i < tempshot.length; i++) {
            GunShot shot = tempshot[i];
            if (shot.distanceDone()) {
                shots.remove(shot);
                m.removeShot(shot);
            }
        }
    }
    public void addShot(double xPos, double yPos, boolean facingRight, Entity ent, Map m) {
        GunShot shot = new GunShot(xPos, yPos, facingRight, ent, m);
        shots.add(shot);
        m.addShot(shot);
    }
}
