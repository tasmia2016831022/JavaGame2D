package shooot.menu;

import shooot.game.Game;
import shooot.map.LevelOne;
import shooot.map.LevelTwo;

/**
 * @author partha
 */
public class LevelPage extends MenuPage {

    public LevelPage() {
        super(new String[]{"Level ONE", "Level TWO","Back"}, "Press Enter to continue");
    }

    @Override
    public void useSelected() {
       if (selected == 0) {
          Game.get().setMap(new LevelOne(""));
            Menu.get().setMenu(OptionPage.get());
            Game.get().menuDone();
        }  else if (selected == 1) {
             Game.get().setMap(new LevelTwo());
            Menu.get().setMenu(OptionPage.get());
            Game.get().menuDone();
        } else if(selected == 2)
        {
            Menu.get().goToPrevious();
        }
    }

}
