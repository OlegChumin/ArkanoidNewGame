import java.awt.*;

public class Bar {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 10;
    public static Color bar_main_color = Color.WHITE;
    public static Color bar_side_color = Color.GRAY;

    public int lives = 3; // количество "жизней"

    public int default_x;
    public int move_speed = 10;

    private Arkanoid game;

    public Bar(Arkanoid game) {
        this.game = game;
    }

    Bar bar = new Bar(new Arkanoid());

    void move(int direction) {

    }

    public static void looseLive(Arkanoid game) {

    }

    public void paintBar(Graphics2D graphics) {
        graphics.setColor(bar_side_color); // рисуем левую часть платформы, цвет серый
        graphics.fillRoundRect(0, 0, 0, 0, 0, 0);

        graphics.setColor(bar_main_color); // рисуем центральную часть платформы, цвет белый
        graphics.fillRoundRect(0, 0, 0, 0 , 0, 0);

        graphics.setColor(bar_side_color);
        graphics.fillRoundRect(0, 0, 0, 0 , 0, 0); //рисуем правую часть платформы, цвет серый
    }



}
