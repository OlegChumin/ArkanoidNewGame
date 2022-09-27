import javax.swing.*;
import java.awt.*;

/**
 Simple arcade desktop classic game Arkanoid wrote by Oleg Chumin
 */
public class Arkanoid extends JPanel{
    public static final int WIDTH = 410; // это константа отвечает за ширину окна
    public static final int HEIGHT = 450; // это константа отвечает за высоту окна

    public static final int DEFAULT_SPEED = 6; // начальная скорость движения объектов в игре

    public int speed = DEFAULT_SPEED; // изменяема скорость игры

    public static boolean pause = false;

    public static boolean start_game = true;

    public static long time_counter = 0;

    public static int ballX = 0;
    public static int ballY = 0;

    public Arkanoid() {
        setLayout(null);
        setVisible(true);
        setBackground(Color.BLACK);
    }

    Ball ball = new Ball(this);
    Bar bar = new Bar(this);
    Bricks brick = new Bricks(this);
    Rewards rewards = new Rewards(this);
    Levels levels = new Levels(this);
    Text text = new Text(this);
    Listeners listeners = new Listeners(this);


    public static void main(String[] args) {
        JFrame arkanoidWindow = gameWindow();
        Arkanoid game = new Arkanoid();

    }

    private static JFrame gameWindow() {
        JFrame frame = new JFrame("Arkanoid game");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        return frame;
    }

    public void gameOver() {

    }

    public static void startGame(Arkanoid game) {

    }
}
