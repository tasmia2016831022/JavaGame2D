package shooot.menu;

import shooot.game.KeyInput;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import shooot.map.Map;

public abstract class MenuPage {

    protected String[] items;

    protected int selected;

    protected String title;

    protected String errorMessage;
    protected Map map;

    public MenuPage(String[] pageItems, String pageTitle) {

        items = pageItems;
        selected = 0;
        title = pageTitle;
        errorMessage = "";
        
    }
    public MenuPage(String[] pageItems, String pageTitle,Map map) {

        items = pageItems;
        selected = 0;
        title = pageTitle;
        errorMessage = "";
        this.map = map;
    }

    public void drawPage(Graphics2D g, Font f) {

        int y = 0;
        float fontSize = f.getSize2D();
        
        g.setFont(f.deriveFont(fontSize*(float)1.25));
        g.setColor(Color.RED);

        FontMetrics fm = g.getFontMetrics();
        y += 50 + fm.getHeight()/2;

        g.drawString(title, 400-(fm.stringWidth(title)/2), y);
        y += fm.getHeight()/2;

        g.setFont(f);
        g.setColor(Color.GREEN);
        y += 50;

        for (int i=0;i<items.length;i++) {

            if (i == selected) {
                g.setFont(f.deriveFont(Font.BOLD,fontSize*(float)2.25));
            }
            
            fm = g.getFontMetrics();

            y += 45 + fm.getHeight()/2;

            g.drawString(items[i], 400-(fm.stringWidth(items[i])/2), y);

            y += fm.getHeight()/2;
            
            g.setFont(f);
        }

        if (!errorMessage.equals("")) {
            g.setFont(f.deriveFont(Font.ITALIC, fontSize*(float)0.75));
            fm = g.getFontMetrics();
            y += 48 + fm.getHeight()/2;
            g.setColor(Color.orange);
            g.drawString("Error: " + errorMessage, 400-(fm.stringWidth("Error: " +errorMessage))/2, y);
        }

    }

    public void selectNext() {
        if (selected < items.length - 1) {
            selected++;
        } else 
        {
            selected = 0;
        }
    }

    public void selectPrevious() {
        if (selected > 0) {
            selected--;
        }
    }

    public abstract void useSelected();

    public void update() {

        if (KeyInput.get().useMenu()) {
            useSelected();
        } else if (!KeyInput.get().getMenuArrowHandeled()) {
            if (KeyInput.get().jump()) {
                KeyInput.get().handleMenuArrow();
                selectPrevious();
            } else if (KeyInput.get().duck()) {
                KeyInput.get().handleMenuArrow();
                selectNext();
            }
        }

    }

    public void reset() {
        selected = 0;
    }

}
