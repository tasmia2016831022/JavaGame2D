package shooot.tools.mapcreator;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author partha
 */
public class Block extends JPanel {

    private int row;
    private int col;

   
    public Block(int row, int col) {
        this.row = row;
        this.col = col;
    }

   
    public void printJava(int offset) {
        System.out.println("worldstore.add(new Floor("+(((row*50)-400)+offset) +","+col*40+",this));");
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(row*20, col*20, 20, 20);
    }

  
    public int getRow() {
        return row;
    }

  
    public int getCol() {
        return col;
    }
}
