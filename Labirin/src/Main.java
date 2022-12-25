import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Labirin Kelompok 1 Algodat");
        Maze maze = new Maze();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,800);
        frame.add(maze);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}