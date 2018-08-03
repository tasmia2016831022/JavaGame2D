package shooot.map.entity;

import shooot.game.Sprite;
import shooot.map.Map;

/**
 *
 * @author partha
 */
public class Crate extends StaticEntity {

   
    public Crate(int posX, int posY, Map m) {
        super(posX, posY, m);
        currentSprite = new Sprite(new String[]{"/pics/crate.png"});
    }
}
