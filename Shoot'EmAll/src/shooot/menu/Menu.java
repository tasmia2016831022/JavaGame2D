package shooot.menu;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author partha
 */
public class Menu {

    private static Menu menu = new Menu();

    private Font font;
    private MenuPage currentPage;
    private MenuPage previousPage;

    private Menu() {

        InputStream is = Menu.class.getResourceAsStream("/fonts/iomanoid.ttf");

        try {
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = font.deriveFont(24f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

         currentPage = OptionPage.get();        
    }

    public static Menu get() {
        return menu;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
        g.setFont(font);

        currentPage.drawPage(g, font);
    }

    public void reset() {
        currentPage = OptionPage.get();
        currentPage.reset();
    }

    public void update() {
        currentPage.update();
    }

    public void setMenu(MenuPage p) {
        currentPage.reset();
        previousPage = currentPage;
        currentPage = p;
        p.reset();
    }

 
    public void goToPrevious() {
        currentPage = previousPage;
    }

    public Font getFont() {
        return font;
    }

}
