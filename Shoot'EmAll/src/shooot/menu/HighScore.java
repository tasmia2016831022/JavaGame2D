
package shooot.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author IICT
 */
public class HighScore extends JFrame{
   JFrame gf ;
   ScorePannel sco;
   public HighScore(){
       try {
            gf = new JFrame();
            gf.setBounds(0, 0, 400, 200);
            sco.loadHighScore();
            sco.setHighScorePanel();
            gf.add(sco.getHighScorePannel());
            gf.setLayout(null);
            gf.setPreferredSize(new Dimension(900,500));
            gf.setBackground(Color.WHITE);
            gf.setDefaultCloseOperation(EXIT_ON_CLOSE);
            gf.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ScorePannel.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    public static void main(String[] args) {
        new HighScore();
    }
    
}
