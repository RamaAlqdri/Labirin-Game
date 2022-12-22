package TES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {
    Timer timer;
    int xVelo = 10;
    int yVelo = 1;
    int x = 0;
    int y = 0;
    JButton tes = new JButton();

    MyPanel(){
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.black);
        tes.setText("TES");
        tes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x=x+xVelo;
                repaint();
            }
        });
        this.add(tes);
//        timer = new Timer(1000,this);
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
//        e.getActionCommand(KeyStroke.getKeyStroke());
//        x = x+xVelo;
//        repaint();
//    }


}
