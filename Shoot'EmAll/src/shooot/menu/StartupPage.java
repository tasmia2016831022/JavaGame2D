package shooot.menu;

import shooot.game.Game;
import shooot.map.LevelOne;
import shooot.map.LevelTwo;
import shooot.menu.ScorePannel;

/**
 * @author partha
 */
public class StartupPage extends MenuPage {

    private static StartupPage page = new StartupPage();

    private StartupPage() {
        super(new String[]{"New GAME", "High Score",  "Exit Game"}, "Choose Gameplay Mode");
    }

    @Override
    public void useSelected() {
        if (selected == 0) {
           Menu.get().setMenu(new LevelPage());
        } else if (selected == 1) {
            new ScorePannel();
        }else if(selected==2){
           Game.get().quit();
        } 
    }

    public static StartupPage get() {
        return page;
    }

}
