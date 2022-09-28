import java.awt.*;

public class Levels {
    public static int current_level = 1;
    public int row_num = 4; // 3 или четыре ряда надо проверить
    public int level_counter = 0;
    Arkanoid game;

    public Levels(Arkanoid game) {
        this.game = game;
    }

    public static void startNewLevel() {

    }


    void createLevel() {

    }

    void drawLevel(int i) {
        // рисует новый уровень
        int level = Levels.current_level;
        if(level == 1) {
            for (int j = 0; j <= 17; j++) {
                Bricks.Brick brick = new Bricks.Brick();
                brick.x += j*20; // дать комментарии
                brick.y = i*20+80; //
                switch(i) {
                    case 0: brick.color = Color.LIGHT_GRAY; // почему здесь i == 0
                    brick.hits = 2;
                    break;
                    case 2: brick.color = Color.YELLOW; // а здесь i == 2
                        brick.hits = 1;
                        break;
                    case 4: brick.color = Color.GREEN; // а здесь i == 4
                        brick.hits = 0;
                        break;
                }
                if(j % 2 != 0 && i % 2 == 0) {
                    game.brick.bricksLine.add(brick);
                } // продолжить с этого места
            }
        }
    }
}
