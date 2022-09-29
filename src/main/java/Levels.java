import java.awt.*;

// код завершен
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
        if(level == 1) { // уровень 1
            for (int j = 0; j <= 17; j++) {
                Bricks.Brick brick = new Bricks.Brick(); // вызов внутреннего класса Brick для создания объекта блок
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
        } else if(level == 2) { // уровень 2
            for (int j = 0; j < 17; j++) { //
                Bricks.Brick brick = new Bricks.Brick();
                if (level_counter == 0) {
                    brick.x += 2 * 21;
                    level_counter = 1;
                } else {
                    brick.x += j * 20;
                }
                brick.y = i * 25 + 50;
                switch(i) {
                    case 1: brick.color = Color.GRAY; // почему здесь i == 1
                        brick.hits = 3;
                        break;
                    case 2: brick.color = Color.LIGHT_GRAY; // а здесь i == 2
                        brick.hits = 2;
                        break;
                    case 3: brick.color = Color.YELLOW; // а здесь i == 4
                        brick.hits = 1;
                        break;
                    case 4: brick.color = Color.GREEN; // а здесь i == 4
                        brick.hits = 0;
                        break;
                }
                if ((j / 1) % 2 != i % 2) { //
                    game.brick.bricksLine.add(brick); // что делает этот код и почему добавлен на уровень 2
                }
            }
        } else if(level == 3) { // уровень 3
            for (int j = 0; j < 14; j++) { // количество блоков на уровне
                Bricks.Brick brick = new Bricks.Brick();
                brick.x += (j * 25) + 10; // определяем координаты верхнего левого угла блока и смещение по оси x
                brick.y = i * 30 + 50; // координата блока по оси y
                switch(i) {
                    case 0: brick.color = Color.DARK_GRAY; // почему здесь i == 1
                        brick.hits = 4; // количество ударов для разрушения блока
                        break;
                    case 1: brick.color = Color.GRAY; // почему здесь i == 1
                        brick.hits = 3; // количество ударов для разрушения блока
                        break;
                    case 2: brick.color = Color.LIGHT_GRAY; // а здесь i == 2
                        brick.hits = 2;
                        break;
                    case 3: brick.color = Color.YELLOW; // а здесь i == 4
                        brick.hits = 1;
                        break;
                    case 4: brick.color = Color.GREEN; // а здесь i == 4
                        brick.hits = 0;
                        break;
                }
                //добавляем еще один ряд блоков в уровень, при выполнении условия
                if ((j) % 3 != i % 3) { // рассказать логику смещения по условию
                    game.brick.bricksLine.add(brick);
                }
            }
        } else if(level == 4) { // уровень 4
            for (int j = 0; j < 17; j++) { // количество блоков на уровне
                Bricks.Brick brick = new Bricks.Brick();
                brick.x += (j * 20) + 10; // определяем координаты верхнего левого угла блока и смещение по оси x
                brick.y = i * 30 + 50; // координата блока по оси y
                switch(i) {
                    case 0: brick.color = Color.DARK_GRAY; // почему здесь i == 1
                        brick.hits = 4; // количество ударов для разрушения блока
                        break;
                    case 1: brick.color = Color.GRAY; // почему здесь i == 1
                        brick.hits = 3; // количество ударов для разрушения блока
                        break;
                    case 2: brick.color = Color.LIGHT_GRAY; // а здесь i == 2
                        brick.hits = 2;
                        break;
                    case 3: brick.color = Color.YELLOW; // а здесь i == 4
                        brick.hits = 1;
                        break;
                    case 4: brick.color = Color.GREEN; // а здесь i == 4
                        brick.hits = 0;
                        break;
                }
                    game.brick.bricksLine.add(brick);
            }
        } else if(level == 5) { // уровень 5
            for (int j = 0; j < 10; j++) { // количество блоков на уровне
                Bricks.Brick brick = new Bricks.Brick();
                brick.x += (j * 28) + ((int) Math.floor(Math.random() * 40 + 1) + 10); // определяем координаты верхнего левого угла блока и смещение по оси x
                brick.y = (i * 15 + 50) + ((int) Math.floor(Math.random() * 10 + 1)); // координата блока по оси y
                switch(i) {
                    case 0: brick.color = Color.DARK_GRAY; // почему здесь i == 1
                        brick.hits = 4; // количество ударов для разрушения блока
                        break;
                    case 1: brick.color = Color.GRAY; // почему здесь i == 1
                        brick.hits = 3; // количество ударов для разрушения блока
                        break;
                    case 2: brick.color = Color.LIGHT_GRAY; // а здесь i == 2
                        brick.hits = 2;
                        break;
                    case 3: brick.color = Color.YELLOW; // а здесь i == 4
                        brick.hits = 1;
                        break;
                    case 4: brick.color = Color.GREEN; // а здесь i == 4
                        brick.hits = 0;
                        break;
                }
                game.brick.bricksLine.add(brick);
            }
        } else {
            for (int j = 0; j < 7; j++) { // количество блоков на уровне
                Bricks.Brick brick = new Bricks.Brick();
                brick.x += (j * 40) + ((int) Math.floor(Math.random() * 40 + 1) + 10); // определяем координаты верхнего левого угла блока и смещение по оси x
                brick.y = (i * 40 + 50) + ((int) Math.floor(Math.random() * 70 + 1)); // координата блока по оси y
                switch(i) {
                    case 0: brick.color = Color.DARK_GRAY; // почему здесь i == 1
                        brick.hits = 4; // количество ударов для разрушения блока
                        break;
                    case 1: brick.color = Color.GRAY; // почему здесь i == 1
                        brick.hits = 3; // количество ударов для разрушения блока
                        break;
                    case 2: brick.color = Color.LIGHT_GRAY; // а здесь i == 2
                        brick.hits = 2;
                        break;
                    case 3: brick.color = Color.YELLOW; // а здесь i == 4
                        brick.hits = 1;
                        break;
                    case 4: brick.color = Color.GREEN; // а здесь i == 4
                        brick.hits = 0;
                        break;
                }
                game.brick.bricksLine.add(brick);
            }
        }
    }
}
