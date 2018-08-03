package shooot.game;

/**
 * @author partha
 */
public class GravityCheck {

    public static double GRAVITY = -700.0;

    public static double calculateGravity(double posY, double pposY, int delta) {
        double dt = delta * 0.001;
        double velocity = (posY-pposY)/(dt);
        double dif = -velocity * dt + GRAVITY * dt * dt;
        return dif;
    }

}
