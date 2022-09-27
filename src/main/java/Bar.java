import java.awt.*;

public class Bar {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 10;
    public static final int SIDE_WITH = 20;
    private static final int BAR_HEIGHT_LEVEL = 30;

    public static Color bar_main_color = Color.WHITE;
    public static Color bar_side_color = Color.GRAY;

    public int x; // координата платформы

//    public
    public int lives = 3; // количество "жизней"

    public int default_x;
    public int move_speed = 10;

    private Arkanoid game;

    public Bar(Arkanoid game) {
        this.game = game;
    }

    void move(int direction) {

    }

    public static void looseLive(Arkanoid game) {

    }

    public static void paintBar(Graphics2D g2) {
        g2.setColor(bar_side_color); // рисуем левую часть платформы, цвет серый
        g2.fillRoundRect(0, 0, 0, 0, 0, 0);

        g2.setColor(bar_side_color); //рисуем правую часть платформы, цвет серый
        g2.fillRoundRect(0, 0, 0, 0 , 0, 0); //рисуем правую часть платформы, цвет серый

        g2.setColor(bar_main_color); // рисуем центральную часть платформы, цвет белый
        g2.fillRoundRect(0, 0, 0, 0 , 0, 0);
    }

    public int getTopY() {return 0;}
    public Rectangle getBoundsLeft() {return new Rectangle(0,0,0,0);}

    public Rectangle getBounds() {return new Rectangle(0,0,0,0);}

    public Rectangle getBoundsRight() {return new Rectangle(0,0,0,0);}

}
