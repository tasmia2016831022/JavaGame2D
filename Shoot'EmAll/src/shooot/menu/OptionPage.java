package shooot.menu;

import shooot.game.Game;
import shooot.map.Map;

/**
 * @author partha
 */
public class OptionPage extends MenuPage {

    private static OptionPage page = new OptionPage();

    private OptionPage() {
        super(new String[]{"Mute", "Reset Position", "Exit Game"}, "Options");
    }

    @Override
    public void useSelected() {
        if (selected == 0) {
            if (items[0].equals("Mute")) {
                Game.get().muteSoundTrack(true);
                items[0] = "UnMute";
            } else {
                Game.get().muteSoundTrack(false);

                items[0] = "Mute";
            }
        } else if (selected == 1) {
            Game.get().resetPlayerPosition();
        } 
        else if (selected == 2) {
            Game.get().quit();
        }
    }

    public static OptionPage get() {
        return page;
    }
}
