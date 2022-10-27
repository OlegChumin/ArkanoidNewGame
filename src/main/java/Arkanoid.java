import javax.swing.*;
import java.awt.*;

/**
 * Simple arcade desktop classic game Arkanoid wrote by Oleg Chumin
 */
public class Arkanoid extends JPanel {
    public static final int WIDTH = 410; // это константа отвечает за ширину окна
    public static final int HEIGHT = 450; // это константа отвечает за высоту окна

    public static int default_speed = 6; // начальная скорость движения объектов в игре

    public int speed = default_speed; // изменяема скорость игры

    public static boolean paused = false;

    public static boolean start_game = true;

    public static long time_counter = 0;

    public static int oldBallXa = 0; //?
    public static int oldBallYa = 0; //?

    public Arkanoid() {
        setLayout(null);
        setVisible(true);
//        setBackground(Color.BLACK);
        setBackground(new Color(0, 10, 59)); // цвет фона
    }

    Ball ball = new Ball(this);
    Bar bar = new Bar(this);
    Bricks brick = new Bricks(this);
    Rewards rewards = new Rewards(this);

    ListenersHandler listeners = new ListenersHandler(this); //?
    Text text = new Text(this);
    Levels levels = new Levels(this);


    private void move() {
        ball.move();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paintBall(g2D);
        bar.paintBar(g2D);
        brick.paintBrick(g2D);
        rewards.paint(g2D);
        text.paint(g2D);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over",
                JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void startGame(Arkanoid game) {
        if (start_game) {
            //выбираем случайное направление меча при старте игры
            int xDirection = (int) Math.floor(Math.random() * 2 + 1);
            game.ball.ya = -1;
            if (xDirection == 1) {
                game.ball.xa = 1;
            } else if (xDirection == 2) {
                game.ball.xa = -1;
            }
            start_game = false;
            game.text.start_label.setText("");
            game.text.level_label.setText("LEVEL " + Levels.current_level);
        } else { // пауза в игре
            if (!paused) {
                oldBallXa = game.ball.xa;
                oldBallYa = game.ball.ya;
                game.ball.ya = 0;
                game.ball.xa = 0;
                game.text.start_label.setText("Game Paused by GameDev2D");
                game.text.start_label.setForeground(Color.RED);
                paused = true;
            } else {
                // возобновляем игру
                game.ball.xa = oldBallXa;
                game.ball.ya = oldBallYa;
                game.text.start_label.setText("");
                game.text.start_label.setForeground(Color.GREEN);
                paused = false;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Arkanoid game by GameDev2D");
        Arkanoid game = new Arkanoid();
        frame.getContentPane().add(game);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // способ отцентровать окно игры или приложения
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        while (true) {
            System.out.println(paused);
            if (!paused && !start_game) {
                game.move();
                game.repaint();
                time_counter++;
                if (time_counter % 100 == 0) { //Сдвигаем все блоки вниз каждые 15 секунд
                    if ((time_counter / 100) % 15 == 0) {
                        for (int i = 0; i < game.brick.bricks.size(); i++) {
                            game.brick.bricks.get(i).y += 10;
                        }
                    }
                    game.rewards.paintReward();
                }
                Thread.sleep(game.speed);
            }
        }
    }
}