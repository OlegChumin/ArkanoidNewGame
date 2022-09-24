import javax.swing.*;
import java.awt.*;

/**
 Simple arcade desktop classic game Arkanoid wrote by Oleg Chumin
 */
public class Arkanoid extends JComponent{
    public static final int WIDTH = 410; // это константа отвечает за ширину окна
    public static final int HEIGHT = 450; // это константа отвечает за высоту окна

    private static class ArkanoidComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.draw(Bar.paintBar());
        }
    }


    public static void main(String[] args) {
        JFrame arkanoidWindow = gameWindow();
        arkanoidWindow.add(new ArkanoidComponent());

    }

    private static JFrame gameWindow() {
        JFrame frame = new JFrame("Arkanoid game");
        Arkanoid game = new Arkanoid();
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        return frame;
    }
}
