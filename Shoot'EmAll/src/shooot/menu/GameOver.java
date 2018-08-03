
package shooot.menu;
import shooot.game.Game;
import shooot.map.Map;
/**
 *
 * @author IICT
 */
public class GameOver extends MenuPage{

    Map m;
    public GameOver(Map m)
    {
        super(new String[]{"Play Again","Exit"},String.format("Congo  Score: %d",m.getScore()),m);
    }
    @Override
    public void useSelected() {
       if(selected==0){
           Game.get().restart();
           Menu.get().setMenu(OptionPage.get());
           Game.get().menuDone();
       } else if (selected == 1)
       {
           Game.get().quit();
       }
    }
    
}
