/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.menu;

import shooot.map.Map;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author IICT
 */
public class ScorePannel extends JFrame{
    private JPanel highScorePanel;
    private JTextField txthighScore;
    protected static int highScore = 0;
    private final String fileScore =
			new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath()).getParent() +
			File.separator + "_score_data_.txt";
    JFrame gf;

public void loadHighScore() throws IOException {
		
		File file = new File(URLDecoder.decode(fileScore, "UTF-8"));
		
		if(!file.canRead()) {
			file.createNewFile();
			setHighScore(0);
		}
		else {
			BufferedReader reader = new BufferedReader(new FileReader(file));//(new InputStreamReader(getClass().getResourceAsStream(fileScore)));
			String line = reader.readLine();
			setHighScore( (line != null) ? Integer.parseInt(line) : 0 );
			reader.close();
		}
	}


public static void setHighScore(int score)  {
		if(score < 0)
			throw new IllegalArgumentException("High Score CANNOT BE a negative number!");
		if(score > highScore){
			highScore = score;
                      
                }
	}
	
	public static int getHighScore() {
		return highScore;
	}

	public void saveHighScore() throws IOException, SecurityException {
		File file = new File(URLDecoder.decode(fileScore, "UTF-8"));
		
		if(!file.canWrite())
			file.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		writer.write(Integer.toString(getHighScore()));
		writer.close();
	}
    public void setHighScorePanel(){
        highScorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        highScorePanel.setBounds(0, 0, 400, 200);
        highScorePanel.setBackground(Color.WHITE);
        
        JPanel inner = new JPanel(new GridLayout(2,1,5,5));
        inner.setPreferredSize(new Dimension(200,100));
        inner.setBackground(Color.WHITE);
        
        JLabel lblmess = new JLabel("HighScore: ",JLabel.CENTER);
        lblmess.setForeground(Color.BLACK);
        lblmess.setHorizontalTextPosition(JLabel.CENTER);
        
        txthighScore = new JTextField(Integer.toString(highScore),6);
        txthighScore.setHorizontalAlignment(JTextField.CENTER);
        txthighScore.setEditable(false);
        
        inner.add(lblmess,BorderLayout.NORTH);
        inner.add(txthighScore,BorderLayout.CENTER);
        
        highScorePanel.add(inner);
       
        
        
    }
    public ScorePannel(){
        try {
            gf = new JFrame();
            gf.setBounds(0, 0, 400, 200);
            loadHighScore();
            setHighScorePanel();
            gf.add(highScorePanel);
            gf.setLayout(null);
            gf.setPreferredSize(new Dimension(900,500));
            gf.setBackground(Color.WHITE);
            gf.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(ScorePannel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ScorePannel(int i){
        
    }
    public JPanel getHighScorePannel(){
        return highScorePanel;
    }
    public static void main(String[] args) throws IOException {
      
        ScorePannel sco = new ScorePannel();

    }
}
