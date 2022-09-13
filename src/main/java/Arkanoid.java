import javax.swing.*;

/**
 Simple arcade desktop classic game Arkanoid wrote by ...
 */
public class Arkanoid {
    public static final int WIDTH = 410; // это константа отвечает за ширину окна
    public static final int HEIGHT = 450; // это константа отвечает за высоту окна



    public static void main(String[] args) {
        JFrame frame = new JFrame("Arkanoid game");
        Arkanoid game = new Arkanoid();
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
