package shooot.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author partha
 */
public class KeyInput implements KeyListener {

    private static KeyInput input = new KeyInput();

    private int jumpButton;
    private int duckButton;
    private int leftButton;
    private int rightButton;
    private int attackButton;
    private int menuButton;
    private int menuChoiceButton;

    private boolean jump;
    private boolean duck;
    private boolean left;
    private boolean right;
    private boolean attack;
    private boolean menu;
    private boolean menuChoice;

    private boolean menuHandeled;
    private boolean menuDirectionHandeled;

    private boolean typing;
    private StringBuffer currentText;
    private String lastFinishedText;

    private KeyInput() {

        jumpButton = KeyEvent.VK_UP;
        duckButton = KeyEvent.VK_DOWN;
        leftButton = KeyEvent.VK_LEFT;
        rightButton = KeyEvent.VK_RIGHT;
        attackButton = KeyEvent.VK_SPACE;
        menuButton = KeyEvent.VK_ESCAPE;
        menuChoiceButton = KeyEvent.VK_ENTER;

        jump = false;
        duck = false;
        left = false;
        right = false;
        attack = false;
        menu = false;
        menuChoice = false;
        menuHandeled = true;

    }

    public static KeyInput get() {
        return input;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (typing) {
            if (e.getKeyCode() == menuChoiceButton) {
                if (currentText.length() > 0) {
                    lastFinishedText = currentText.toString();
                } else {
                    lastFinishedText = "";
                }
                currentText = new StringBuffer();
                typing = false;
            } else if (e.getKeyCode() == menuButton) {
                lastFinishedText = "";
                currentText = new StringBuffer();
                typing = false;
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                if (currentText.length() > 0) {
                    currentText.deleteCharAt(currentText.length() - 1);
                }
            } else if (e.getKeyChar() != KeyEvent.CHAR_UNDEFINED) {
                currentText.append(e.getKeyChar());
            }

        } else {
            if (e.getKeyCode() == attackButton) {
                attack = true;
            } else if (e.getKeyCode() == jumpButton) {
                jump = true;
                menuDirectionHandeled = false;
            } else if (e.getKeyCode() == leftButton) {
                left = true;
            } else if (e.getKeyCode() == rightButton) {
                right = true;
            } else if (e.getKeyCode() == duckButton) {
                duck = true;
                menuDirectionHandeled = false;
            } else if (e.getKeyCode() == menuButton) {
                menu = true;
                menuHandeled = false;
            } else if (e.getKeyCode() == menuChoiceButton) {
                menuChoice = true;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == attackButton) {
            attack = false;
        } else if (e.getKeyCode() == jumpButton) {
            jump = false;
        } else if (e.getKeyCode() == leftButton) {
            left = false;
        } else if (e.getKeyCode() == rightButton) {
            right = false;
        } else if (e.getKeyCode() == duckButton) {
            duck = false;
        } else if (e.getKeyCode() == menuButton) {
            menu = false;
        } else if (e.getKeyCode() == menuChoiceButton) {
            menuChoice = false;
        }
    }

    public boolean right() {
        return right;
    }

    public boolean left() {
        return left;
    }

    public boolean duck() {
        return duck;
    }

    public boolean jump() {
        return jump;
    }

    public boolean menu() {
        return menu;
    }

    public boolean attack() {
        return attack;
    }

    public void setRightButton(int newKeyCode) {
        rightButton = newKeyCode;
    }

    public void setLeftButton(int newKeyCode) {
        leftButton = newKeyCode;
    }

    public void setJumpButton(int newKeyCode) {
        jumpButton = newKeyCode;
    }

    public void setDuckButton(int newKeyCode) {
        duckButton = newKeyCode;
    }

    public void setAttackButton(int newKeyCode) {
        attackButton = newKeyCode;
    }

    public void setMenuButton(int newKeyCode) {
        attackButton = newKeyCode;
    }

    public boolean getMenuHandeled() {
        return menuHandeled;
    }

    public boolean getMenuArrowHandeled() {
        return menuDirectionHandeled;
    }

    public boolean useMenu() {
        boolean b = menuChoice;
        menuChoice = false;
        return b;
    }

    public void handleMenu() {
        menuHandeled = true;
    }

    public void handleMenuArrow() {
        menuDirectionHandeled = true;
    }

    public boolean isTyping() {
        return typing;
    }

    public String getCurrentText() {
        return currentText.toString();
    }

    public String getFinalText() {
        return lastFinishedText;
    }

    public void requestString(String currentString) {
        currentText = new StringBuffer(currentString);
        typing = true;
    }

    public void requestString() {
        requestString("");
    }

}
