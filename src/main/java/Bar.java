import java.awt.*;

public class Bar {
    public static final int Y = 40;
    public static int barWidth = 30;
    public static int barHeight = 10;
    public static int barSideWidth = 20;

    public static Color bar_main_color = Color.WHITE;
    public static Color bar_side_color = Color.GRAY;

    public int lives = 3; // количество "жизней"

    public static int default_x = 197;

    public int x = default_x; // координата платформы
    public int move_speed = 10;

    private Arkanoid game;

    public Bar(Arkanoid game) {
        this.game = game;
    }

    void move(int direction) { // движение платформы
        // кнопки влево и вправо
        int width_marging = 5;
        if (direction == ListenersHandler.LEFT) {
            if (x > width_marging) {
                x -= move_speed;
            }
        } else if (direction == ListenersHandler.RIGHT) {
            if (x < game.getWidth() - (barWidth + width_marging)) {
                x += move_speed;
            }
        }
    }

    public static void looseLive(Arkanoid game) { // потеря жизней
        game.bar.lives--;
        Arkanoid.start_game = true;
        game.ball.xa = 0;
        game.ball.ya = 0;
        game.ball.x = Ball.default_x;
        game.ball.y = Ball.default_y;
        game.bar.x = Bar.default_x;
        game.text.lives_label.setText("" + game.bar.lives);
        game.text.start_label.setText("Lives" + game.bar.lives);
        game.speed = Arkanoid.default_speed;
        game.rewards.stopAllRewards();
    }

    public void paintBar(Graphics2D g2) { // отрисовываем платформу (биту)
        g2.setColor(bar_side_color); // рисуем левую часть платформы, цвет серый
        g2.fillRoundRect(x - (barSideWidth - 3), game.getHeight() - Y, barSideWidth, barHeight, 10, 10);

        g2.setColor(bar_side_color); //рисуем правую часть платформы, цвет серый
        g2.fillRoundRect(x + (barWidth - 3), game.getHeight() - Y, barSideWidth, barHeight, 10, 10); //рисуем правую часть платформы, цвет серый

        g2.setColor(bar_main_color); // рисуем центральную часть платформы, цвет белый
        g2.fillRect(x, game.getHeight() - Y, barWidth, barHeight);
    }

    public int getTopY() {
        return game.getHeight() - Y - barHeight;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, game.getHeight() - Y, barWidth, barHeight);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle(x - 20, game.getHeight() - Y, barWidth - 3, barHeight);
    }


    public Rectangle getBoundsRight() {
        return new Rectangle(x + 20, game.getHeight() - Y, barWidth - 3, barHeight);
    }
}
