package TES;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {
    boolean right=false;
    boolean left=false;
    boolean top=false;
    boolean bottom=false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_DOWN:
                bottom = true;
                System.out.println(e.getKeyCode());;
                break;
            case KeyEvent.VK_UP:
                top = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_DOWN:
                bottom = false;
                System.out.println(e.getKeyCode());;
                break;
            case KeyEvent.VK_UP:
                top = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;

        }
    }
}
