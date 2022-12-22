import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Maze extends JPanel {
    Graph graph;
    Map map = new Map();
    Vertex vertex;
    JButton buttonUp = new JButton();
    JButton buttonDown = new JButton();
    JButton buttonLeft = new JButton();
    JButton buttonRight = new JButton();
    JButton reset = new JButton();
    Maze(){
        map.makemap();
        graph = map.map;
        vertex = graph.head;
        vertex.cursor=true;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(700,800));
        this.setBackground(Color.decode("#c8c8c8"));
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
        reset.setText("RESET");
        reset.setBounds(600,745,75,35);
        reset.setBackground(Color.ORANGE);

        JLabel title = new JLabel("MAZE GAME");
        title.setBounds(235,20,230,60);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Dungeon", Font.BOLD,35));

        buttonUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo("Top");
                repaint();
            }
        });
        buttonDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo("Bottom");
                repaint();
            }
        });
        buttonLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo("Left");
                repaint();
            }
        });
        buttonRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateTo("Right");
                repaint();
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                repaint();
            }
        });
        this.add(buttonUp);
        this.add(buttonDown);
        this.add(buttonLeft);
        this.add(buttonRight);
        this.add(reset);
        this.add(title);
    }
    public void paint(Graphics g){
        if (vertex.visited){
            JOptionPane.showMessageDialog(this,"Tidak Boleh");
            reset();
        }
        if (vertex.name.equals("Finish")){
            JOptionPane.showMessageDialog(this,"Finish");
            reset();
        }
        super.paint(g);
        Graphics2D title = (Graphics2D) g;
        title.setPaint(Color.BLACK);
        int xStart = 280;
        int yStart = 120;
        int size = 60;
        Vertex current = graph.head;
        current.x=xStart;
        current.y=yStart;

        while(current!=null){
            Edge.Node neighboor = current.edge.head;
            while(neighboor!=null) {
                if (neighboor.direction.equals("Right")) {
                    neighboor.destination.x = current.x + size;
                    neighboor.destination.y = current.y;
                } else if (neighboor.direction.equals("Left")) {
                    neighboor.destination.x = current.x - size;
                    neighboor.destination.y = current.y;
                } else if (neighboor.direction.equals("Top")) {
                    neighboor.destination.x = current.x;
                    neighboor.destination.y = current.y - size;
                } else if (neighboor.direction.equals("Bottom")) {
                    neighboor.destination.x = current.x;
                    neighboor.destination.y = current.y + size;
                }
                neighboor = neighboor.next;
            }
            current=current.next;
        }
        current = graph.head;
        while(current!=null){
            Graphics2D visit = (Graphics2D) g;
            if (current.visited){
                visit.setPaint(Color.YELLOW);
                visit.fillRect(current.x+size/4, current.y+size/4,size/2,size/2);
            }
            if (current.cursor){
                visit.setPaint(Color.RED);
                visit.fillOval(current.x+size/4, current.y+size/4,size/2,size/2);
                vertex.visited=true;
                current.cursor=false;
            }
            current = current.next;
        }
        current = graph.head;
        while(current!=null){
            Graphics2D batas = (Graphics2D) g;
            batas.setPaint(Color.black);
            if (!(current.name.equals("Start")||current.name.equals("Finish"))){

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
            }
            current = current.next;
        }

    }
    public void navigateTo(String decision){
        Edge.Node neighboor = vertex.edge.head;
        String before = vertex.name;
        while (neighboor!=null){
            if (neighboor.direction.equals(decision)){
                if (vertex.name.equals("Start")){
                    vertex.cursor=false;
                }
                vertex = neighboor.destination;
                vertex.cursor=true;
            }
            neighboor=neighboor.next;
        }
        if (before.equals(vertex.name)){
            vertex.cursor=true;
            vertex.visited=false;
        }
    }
    public void reset(){
        map.makemap();
        graph= map.map;
        vertex = graph.head;
        vertex.cursor=true;
    }
}