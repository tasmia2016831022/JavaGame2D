package shooot.game;

import shooot.menu.Menu;
import shooot.menu.StartupPage;
import shooot.map.Map;
import shooot.menu.DeathPage;
import shooot.menu.GameOver;
import shooot.menu.ScorePannel;
import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author partha
 */
public class Game extends Canvas {

    private BufferStrategy strategy;

    private JFrame container;

    private JPanel panel;

    private long lastUpdateTime;

    private GameUpdater updater;

    private Timer timer;

    private RenderThread renderer;

    private Map map;

    private boolean menu;

    private static Game game = new Game();

    private ScorePannel sco;

    private Game() {

        container = new JFrame("Shot_them_ALL");
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lastUpdateTime = System.currentTimeMillis();

        panel = (JPanel) container.getContentPane();
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setLayout(null);

        setIgnoreRepaint(true);

        container.addKeyListener(KeyInput.get());
        this.addKeyListener(KeyInput.get());
    }

    public void start() {

        setBounds(0, 0, 800, 600);
        panel.add(this);

        container.pack();
        container.setResizable(false);
        container.setVisible(true);

        createBufferStrategy(2);
        strategy = getBufferStrategy();

        Menu.get().setMenu(StartupPage.get());
        menu = true;
        updater = new GameUpdater(this);
        timer = new Timer();
        timer.schedule(updater, 0, 16);

        renderer = new RenderThread(this);
        renderer.setPriority(RenderThread.NORM_PRIORITY);
        renderer.start();
        sco = new ScorePannel(5);

    }

    public void updateGame() {
        if (KeyInput.get().menu() && !KeyInput.get().getMenuHandeled()) {
            if (!menu) {
                menu = true;
                KeyInput.get().handleMenu();

            } else {
                menu = false;
                KeyInput.get().handleMenu();
            }
        }
        if ((!menu && map != null)) {
            lastUpdateTime = System.currentTimeMillis();
            map.update();
            if (map.isDead()) {
                int ttemp = map.getScore();
                if (ttemp > sco.getHighScore()) {
                    sco.setHighScore(ttemp);

                    System.out.println(sco.getHighScore() + " " + ttemp);
                    try {
                        sco.saveHighScore();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    } catch (SecurityException e) {
                        System.err.println(e.getMessage());
                    }
                }
                Menu.get().setMenu(new DeathPage());

                menu = true;
            } else if (map.isFinish()) {
                int ttemp = map.getScore();
                if (ttemp > sco.getHighScore()) {
                    sco.setHighScore(ttemp);
                    System.out.println(sco.getHighScore() + " " + ttemp);
                    try {
                        sco.saveHighScore();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    } catch (SecurityException e) {
                        System.err.println(e.getMessage());
                    }
                }
                Menu.get().setMenu(new GameOver(map));
                menu = true;
            }
        } else if (menu) {
            Menu.get().update();
            if (map != null) {
                map.updateWhileMenu();
            }
        }
    }

    /**
     * @param delta 
     * @param fps 
     */
    public void renderGraphics(long delta, int fps) {

        Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 600);
        if (map != null) {
            map.render(g, (int) delta);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800, 800);
        }

        if (menu) {
            g.setColor(Color.BLACK);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) 0.6));
            g.fillRect(0, 0, 800, 600);
            Menu.get().render(g);
        }

        Font f = getStandardFont();
        g.setFont(f.deriveFont(f.getSize2D() * 0.75f));
        FontMetrics fm = g.getFontMetrics();

        if (fps != 0) {
            g.setColor(Color.BLACK);
            g.drawString("FPS: " + fps, 450 - 5 - fm.stringWidth("FPS: " + fps), fm.getHeight() + 3);
        }

        if (map != null) {
            g.setColor(Color.RED);
            g.drawString("Health: " + map.getPlayerHp() + "%", 5, fm.getHeight() + 3);

            g.setColor(Color.BLACK);
            g.drawString("Score: " + map.getScore(), 800 - 5 - fm.stringWidth("Score: " + map.getScore()), fm.getHeight() + 3);
        }

        g.dispose();
        strategy.show();

    }

    public void quit() {
        System.exit(0);
    }

    public static Game get() {
        return game;
    }

    public void setMap(Map sMap) {
        map = sMap;
    }

    public void menuDone() {
        menu = false;
    }

    public void setMenuD() {
        menu = true;
    }

    public double[] getPlayerState() {
        return map.getPlayerState();
    }

    public void resetPlayerPosition() {
        map.resetPlayerPosition();
    }

    public void restart() {
        map.reset();
    }

    public static Font getStandardFont() {
        return Menu.get().getFont();
    }

    public void muteSoundTrack(boolean mute) {
        map.mute(mute);
    }
}
