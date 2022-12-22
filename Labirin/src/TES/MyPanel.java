package TES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {
    Timer timer;
    int xVelo = 10;
    int yVelo = 1;
    int x = 0;
    int y = 0;
    MyPanel(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.black);
//        timer
//        timer = new Timer(1000,this)
//        timer.start();
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.RED);
        g2D.fillOval(x,y,60,60);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        x = x+xVelo;
//        repaint();
//    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_ENTER:
                x = x+xVelo;
                System.out.println(x);
                repaint();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
