package shooot.menu;

import shooot.game.Game;

/**
 * @author partha
 */
public class DeathPage extends MenuPage {

    public DeathPage() {
        super(new String[]{"Retry", "Exit Game"}, "You are dead! :)");
    }

    @Override
    public void useSelected() {
        if (selected == 0) {
            Game.get().restart();
            Menu.get().setMenu(OptionPage.get());
            Game.get().menuDone();
        } else if (selected == 1) {
            Game.get().quit();
        }
    }



}
