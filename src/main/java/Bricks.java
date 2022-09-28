import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// класс Bricks закончен

public class Bricks {

    public List<Brick> bricksLine = new ArrayList<>(); // создаем ряд кирпичей
    // aray[i] = ....      bricksLine.get(brick)
    public ArrayList<ArrayList<Brick>> brickRows = new ArrayList<>(); // создаем все ряды кирпичей


    private Arkanoid game;

    public Bricks(Arkanoid game) {
        this.game = game;
    }

    public static class Brick {
        private static int width = 15; // ширина блока brick
        public static int height = 10; // высота блока brick

        int x = 15;
        int y = 50;

        Color color = Color.BLACK;
        int hits = 1;

        String reward_type = "";

        int reward_num = (int) Math.floor(Math.random() * hits + 1); // переменная отвечающая за приращение
        // результатов игры

        public boolean hasRewards() {
            if (reward_type != "" && reward_num == hits) {
                return true;
            }
            return false;
        }

        public int getTopY() {
            return y - height;
        }

        public Rectangle getBounds() {
            return new Rectangle(x, y, width, height);
        }
    }

    void updateHits(int brick) {
        int hits = bricksLine.get(brick).hits;
        switch (hits) {
            case 1:
                bricksLine.get(brick).color = Color.GREEN;
                break;
            case 2:
                bricksLine.get(brick).color = Color.YELLOW;
                break;
            case 3:
                bricksLine.get(brick).color = Color.LIGHT_GRAY;
                break;
            case 4:
                bricksLine.get(brick).color = Color.GRAY;
                break;
            case 5:
                bricksLine.get(brick).color = Color.DARK_GRAY;
                break;
        }
        bricksLine.get(brick).hits -= 1;
    }


    public void paint(Graphics2D graphics) {
        for (int i = 0; i < game.brick.brickRows.size(); i++) {
            for (int j = 0; j < game.brick.brickRows.get(i).size(); j++) {
                graphics.setColor(game.brick.brickRows.get(i).get(j).color);
                graphics.fillRect(game.brick.brickRows.get(i).get(j).x, game.brick.brickRows.get(i).get(j).y,
                        game.brick.brickRows.get(i).get(j).width, game.brick.brickRows.get(i).get(j).height);
            }
        }
    }
}
