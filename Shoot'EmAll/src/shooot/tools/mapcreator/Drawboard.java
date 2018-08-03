package shooot.tools.mapcreator;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPanel;

/**
 *
 * @author partha
 * @version 1.0
 */
public class Drawboard extends JPanel implements MouseListener, MouseMotionListener {

    private Datahistory db;
    private int focus = 4;
    private boolean fill = false;
    private boolean er = false;
    private int offset = 0;

    /**
     * 
     */
    public Drawboard(Datahistory db) {
        addMouseListener(this);
        addMouseMotionListener(this);
        this.db = db;
    }

    /**
     
     */
    public boolean getFill() {
        if (fill) {
            fill = false;
        } else {
            fill = true;
        }
        return fill;
    }

    /**
     
     * @return focus int
     */
    public int getFocus() {
        return focus;
    }

    /**
     * 
     *
     */
    public void setFocus(int focus) {
        this.focus = focus;
    }

    /**
     
     */
    @Override
    public void paint(Graphics g) {


        g.clearRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < getWidth(); i += 20) {
            g.drawLine(i, 0, i, getHeight());
        }

        for (int i = 0; i < getHeight(); i += 20) {
            g.drawLine(0, i, getWidth(), i);
        }
        db.paint(g);
    }

    /**
     * 
     * @param e Mousevent
     */
    public void mousePressed(MouseEvent e) {
    }

    /**
     */
    public void mouseReleased(MouseEvent e) {
        repaint();
    }

    /**
     *
     */
    public void clear() {
        db.clear();
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1500, 300);
    }

    /**
     */
    public void back() {
        db.back();
        repaint();
    }

    /**
     * 
     */
    public void er() {
        if (er) {
            er = false;
        } else {
            er = true;
        }
    }

    /**
     * 
     */
    public void mouseDragged(MouseEvent arg0) {
        repaint();
    }

    public void mouseClicked(MouseEvent e) {
        int row = (e.getX()/20);
        int col = (e.getY()/20);
        if (!db.remove(row,col)) {
            db.add(new Block(row,col));
        }
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent arg0) {
    }

    public void setOffset(int i) {
        db.setCurrentDB(i);
        repaint();
    }

 
}
