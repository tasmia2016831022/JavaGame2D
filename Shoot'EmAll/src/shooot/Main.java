package shooot;

import shooot.game.Game;

/**
 * @author partha
 */
public class Main {

    public static void main(String[] args) {
        try{
        Game g = Game.get();
        g.start();
        }catch (Exception e){
            System.err.println(e);
        }

    }

}
