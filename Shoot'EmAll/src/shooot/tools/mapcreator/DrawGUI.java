package shooot.tools.mapcreator;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

/**
 * 
 *
 * @author partha
 * @version 0.10
 */
public class DrawGUI {

    private Datahistory db;
    private JFileChooser fc;
    private JToggleButton[][] buttons;
    private ButtonGroup[] groups;

    /**
     *
     */
    public DrawGUI() {
        buttons = new JToggleButton[2][5];
        groups = new ButtonGroup[2];
        db = new Datahistory();
        fc = new JFileChooser();
        makeFrame();
    }

    
    public static void main(String[] args) {
        new DrawGUI(); 
    }

    /**
     */
    public void makeFrame() {
        JFrame mainFrame = new JFrame("Map generator");
        final Drawboard drawBoard = new Drawboard(db);
        makeMenu(mainFrame, drawBoard);

        Container contentPane = mainFrame.getContentPane();
        contentPane.add(drawBoard);

        mainFrame.setBackground(Color.white);
        mainFrame.pack();
        mainFrame.setVisible(true);

        mainFrame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            } });
    }

    
    private void makeMenu(final JFrame mainFrame, final Drawboard drawBoard) {

        JMenuBar menubar = new JMenuBar();
        mainFrame.setJMenuBar(menubar);
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Offset");

        JMenuItem offset0 = new JMenuItem("Offset: 0");
       
        offset0.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    drawBoard.setOffset(0);
                    drawBoard.repaint();
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
        });
        editMenu.add(offset0);


        JMenuItem offset1 = new JMenuItem("Offset: 1");
        // Action listiner for file-opening
        offset1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    drawBoard.setOffset(1);
                    drawBoard.repaint();
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
        });
        editMenu.add(offset1);

        JMenuItem offset2 = new JMenuItem("Offset: 2");
       
        offset2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    drawBoard.setOffset(2);
                    drawBoard.repaint();
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
        });
        editMenu.add(offset2);


      
        JMenuItem item1 = new JMenuItem("Clear");
      
        item1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    db.clear();
                    drawBoard.repaint();
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
        });
        fileMenu.add(item1);


        // Action listiner for file-saving
        JMenuItem item2 = new JMenuItem("Show");
        item2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    db.printall();
                    drawBoard.repaint();
                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }
            }
        });
        fileMenu.add(item2);
        fileMenu.add(new JSeparator());


     
        menubar.add(fileMenu);
        menubar.add(editMenu);

    }

   
    private File getFile() throws Exception {
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            return file;
        }
        return null;
    }
}
