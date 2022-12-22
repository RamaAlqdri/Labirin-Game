import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
public class Maze {
    Graph graph;
    Vertex CURRENT=null;
    public void play(JFrame frame){
        Map map = new Map();
        map.makemap();
        graph = map.map;
        JLayeredPane layeredPane = new JLayeredPane();
        CURRENT = graph.searchVertex("Start");
        CURRENT.visited=true;
        showmap(frame,graph,layeredPane);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_DOWN:
                        navigateTo("Bottom");
                        System.out.println(e.getKeyCode());
                        System.out.println(CURRENT.name);
                        showmap(frame,graph,layeredPane);
                        break;
                    case KeyEvent.VK_UP:
                        navigateTo("Top");
                        break;
                    case KeyEvent.VK_LEFT:
                        navigateTo("Left");
                        break;
                    case KeyEvent.VK_RIGHT:
                        navigateTo("Right");
                        break;

                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    public void showmap(JFrame frame, Graph graph, JLayeredPane layeredPane){
        layeredPane.setBounds(0,0,700,800);
        Vertex current = graph.head;
        int xStart = 280;
        int yStart = 120;
        int size = 60;
        JLabel start = new JLabel();
        start.setBounds(xStart,yStart,size,size);
        start.setBackground(Color.white);
        frame.add(start);
        current.mark=true;
        current.x=xStart;
        current.y=yStart;
        while (current!=null){
            Edge.Node neighboor = current.edge.head;
            while(neighboor!=null){
                JLabel box = new JLabel();
                if (!neighboor.destination.mark){
                    int edgelenght=0;
                    if (neighboor.direction.equals("Right")){
                        neighboor.destination.x=current.x+neighboor.distance*size;
                        neighboor.destination.y=current.y;
                        edgelenght=neighboor.destination.x-current.x+size;
                        box.setBounds(current.x,current.y,edgelenght,size);
                    }
                    else if (neighboor.direction.equals("Left")){
                        neighboor.destination.x=current.x-neighboor.distance*size;
                        neighboor.destination.y=current.y;
                        edgelenght=current.x-neighboor.destination.x+size;
                        box.setBounds(neighboor.destination.x,current.y,edgelenght,size);
                    }
                    else if (neighboor.direction.equals("Top")){
                        neighboor.destination.x=current.x;
                        neighboor.destination.y=current.y-neighboor.distance*size;
                        edgelenght=current.y-neighboor.destination.y+size;
                        box.setBounds(current.x,neighboor.destination.y,size,edgelenght);
                    }
                    else if (neighboor.direction.equals("Bottom")){
                        neighboor.destination.x=current.x;
                        neighboor.destination.y=current.y+neighboor.distance*size;
                        edgelenght=neighboor.destination.y-current.y+size;
                        box.setBounds(current.x,current.y,size,edgelenght);
                    }
                    neighboor.destination.mark=true;
                }
                if (neighboor.destination.visited){
                    box.setBackground(Color.DARK_GRAY);
                }else{
                    box.setBackground(Color.white);
                }
                box.setOpaque(true);
                layeredPane.add(box, Integer.valueOf(0));

                line(current,frame,size,layeredPane);
                neighboor=neighboor.next;
            }
            current=current.next;
        }
        layeredPane.repaint();
        frame.add(layeredPane);
        frame.setVisible(true);
    }
    public void line(Vertex vertex,JFrame frame,int size, JLayeredPane layeredPane){
        if (!vertex.isRightAvailable()){
            JLabel line = new JLabel();
            line.setBounds(vertex.x+size,vertex.y,6,size+6);
            line.setBackground(Color.black);
            line.setOpaque(true);
            layeredPane.add(line, Integer.valueOf(2));
        }
        if (!vertex.isLeftAvailable()){
            JLabel line = new JLabel();
            line.setBounds(vertex.x,vertex.y,6,size);
            line.setBackground(Color.black);
            line.setOpaque(true);
            layeredPane.add(line, Integer.valueOf(2));
        }
        if (!vertex.isTopAvailable()){
            JLabel line = new JLabel();
            line.setBounds(vertex.x,vertex.y,size,6);
            line.setBackground(Color.black);
            line.setOpaque(true);
            layeredPane.add(line, Integer.valueOf(2));
        }
        if (!vertex.isBottomAvailable()){
            JLabel line = new JLabel();
            line.setBounds(vertex.x,vertex.y+size,size,6);
            line.setBackground(Color.black);
            line.setOpaque(true);
            layeredPane.add(line, Integer.valueOf(2));
        }


    }
    public void navigateTo(String decision){
        Edge.Node neighboor = CURRENT.edge.head;
        while (neighboor!=null){
            if (neighboor.direction.equals(decision)){
                CURRENT = neighboor.destination;
                CURRENT.visited=true;
            }
            neighboor=neighboor.next;
        }
    }
    public void directionOf(Vertex vertex){
        Edge.Node neighboor = vertex.edge.head;
        while(neighboor!=null){
            System.out.println(neighboor.direction);
            neighboor=neighboor.next;
        }
    }
    public boolean isFinish(Vertex vertex){
        return(vertex.name.equals("Finish"));
    }
}
