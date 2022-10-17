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

    public static int oldBallXa = 0; //?
    public static int oldBallYa = 0; //?

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

    Listeners listeners = new Listeners(this); //?
    private void move() {
        ball.move();
    }


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

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paintBall(g2D);
        bar.paintBar(g2D);
        brick.paint(g2D);
        rewards.paint(g2D);
        text.paint(g2D);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over",
                JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void startGame(Arkanoid game) {
        if(start_game) {
            //выбираем случайное направление меча при старте игры
            int xDirection = (int) Math.floor(Math.random() * 2 + 1);
            game.ball.ya = -1;
            if(xDirection == 1) {
                game.ball.xa = 1;
            }
        }

    }
}
