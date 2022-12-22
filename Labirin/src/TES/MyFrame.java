package TES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.BLUE);
        g2D.fillRect(50,50,60,60);

    }
}
