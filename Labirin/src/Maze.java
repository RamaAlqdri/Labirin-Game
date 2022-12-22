import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
public class Maze extends JPanel {
    Graph graph;
    Map map = new Map();
    Vertex vertex = null;
    JButton buttonUp = new JButton();
    JButton buttonDown = new JButton();
    JButton buttonLeft = new JButton();
    JButton buttonRight = new JButton();
    Maze(){
        map.makemap();
        graph = map.map;
        vertex = graph.head;

        this.setLayout(null);
        this.setPreferredSize(new Dimension(700,800));
        this.setBackground(Color.DARK_GRAY);
        buttonDown.setText("DOWN");
        buttonDown.setBounds(305,740,90,40);
        buttonDown.setBackground(Color.ORANGE);
        buttonUp.setText("UP");
        buttonUp.setBounds(305,690,90,40);
        buttonUp.setBackground(Color.ORANGE);
        buttonLeft.setText("LEFT");
        buttonLeft.setBounds(205,740,90,40);
        buttonLeft.setBackground(Color.ORANGE);
        buttonRight.setText("RIGHT");
        buttonRight.setBounds(405,740,90,40);
        buttonRight.setBackground(Color.ORANGE);
        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo("Top");
                System.out.println(vertex.name);
                repaint();
            }
        });
        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo("Bottom");
                System.out.println(vertex.name);
                repaint();
            }
        });
        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo("Left");
                System.out.println(vertex.name);
                repaint();
            }
        });
        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo("Right");
                System.out.println(vertex.name);
                repaint();
            }
        });

        this.add(buttonUp);
        this.add(buttonDown);
        this.add(buttonLeft);
        this.add(buttonRight);
    }
    public void paint(Graphics g){
        super.paint(g);
        int xStart = 280;
        int yStart = 120;
        int size = 60;
        Vertex current = graph.head;
        current.x=xStart;
        current.y=yStart;
        current.visited=true;
        while(current!=null){
            Graphics2D lintasan = (Graphics2D) g;
            Edge.Node neighboor = current.edge.head;
            while(neighboor!=null){
                lintasan.setPaint(Color.WHITE);
                if (!neighboor.destination.mark){
                    int edgelenght;
                    if (neighboor.direction.equals("Right")){
                        neighboor.destination.x=current.x+neighboor.distance*size;
                        neighboor.destination.y=current.y;
                        edgelenght=neighboor.destination.x-current.x+size;
                        lintasan.fillRect(current.x,current.y,edgelenght,size);
                    }else if (neighboor.direction.equals("Left")){
                        neighboor.destination.x=current.x-neighboor.distance*size;
                        neighboor.destination.y=current.y;
                        edgelenght=current.x-neighboor.destination.x+size;
                        lintasan.fillRect(neighboor.destination.x,current.y,edgelenght,size);
                    }else if (neighboor.direction.equals("Top")){
                        neighboor.destination.x=current.x;
                        neighboor.destination.y=current.y-neighboor.distance*size;
                        edgelenght=current.y-neighboor.destination.y+size;
                        lintasan.fillRect(current.x,neighboor.destination.y,size,edgelenght);
                    }else if (neighboor.direction.equals("Bottom")){
                        neighboor.destination.x=current.x;
                        neighboor.destination.y=current.y+neighboor.distance*size;
                        edgelenght=neighboor.destination.y-current.y+size;
                        lintasan.fillRect(current.x,current.y,size,edgelenght);
                    }
                    neighboor.destination.mark=true;
                }
                neighboor=neighboor.next;
            }
            current=current.next;
        }
        current = graph.head;
        while(current!=null){
            Graphics2D visit = (Graphics2D) g;
            if (current.visited){
                visit.setPaint(Color.GRAY);
                visit.fillRect(current.x, current.y,size,size);
            }
            if (current.cursor){
                visit.setPaint(Color.RED);
                visit.fillRect(current.x, current.y,size,size);
                current.cursor=false;
            }
            current = current.next;
        }
        current = graph.head;
        graph.unmarked();
        while(current!=null){
            Graphics2D batas = (Graphics2D) g;
            batas.setPaint(Color.BLACK);
            if (!current.isRightAvailable()){
                batas.fillRect(current.x+size,current.y,6,size+6);
            }
            if (!current.isLeftAvailable()){
                batas.fillRect(current.x,current.y,6,size);
            }
            if (!current.isTopAvailable()){
                batas.fillRect(current.x,current.y,size,6);
            }
            if (!current.isBottomAvailable()){
                batas.fillRect(current.x,current.y+size,size,6);
            }
            current = current.next;
        }

    }
    public void navigateTo(String decision){
        Edge.Node neighboor = vertex.edge.head;
        while (neighboor!=null){
            if (neighboor.direction.equals(decision)){
                vertex = neighboor.destination;
                vertex.visited=true;
                vertex.cursor=true;
            }
            neighboor=neighboor.next;
        }
    }
//    public void directionOf(Vertex vertex){
//        Edge.Node neighboor = vertex.edge.head;
//        while(neighboor!=null){
//            System.out.println(neighboor.direction);
//            neighboor=neighboor.next;
//        }
//    }
//    public boolean isFinish(Vertex vertex){
//        return(vertex.name.equals("Finish"));
//    }
}
