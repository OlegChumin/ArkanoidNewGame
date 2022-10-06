import java.awt.*;

/**
 * Ball responsible for all kind of balls in the game
 */

public class Ball {
    public static int diameter = 10;
    public static final int DEFAULT_X = 205;
    public static final int DEFAULT_Y = 350;

    int x = DEFAULT_X;
    int y = DEFAULT_Y;

    int xa = 0;
    int ya = 0;

    int brick;

    int ballTopPosition = 0;
    int ballBottomPosition = 0;
    int ballRightPosition = 0;
    int ballLeftPosition = 0;

    int brickTopPosition = 0;
    int brickBottomPosition = 0;
    int brickLeftPosition = 0;
    int brickRightPosition = 0;

    public static boolean bigBallMode = false;
    public static int bigBallModeColor = 0;

    public static boolean ultraBallMode = false;

    public static int ultraBallColor = 0;
    public static boolean fireBallMode = false;


    public static int fireBallModeColor = 5; //дописать в код

    private Arkanoid game;

    public Ball(Arkanoid game) {
        this.game = game;
    }

    void move() {
        // смена направления полета меча при столкновениях с границами игрового поля
        if (x + xa <= 0) {
            xa *= -1;
        } else if (x + xa >= game.getWidth() - diameter) {
            xa = -xa;
        } else if (y + ya <= Text.menu_bar_height) {
            ya = 1;
        } else if (y + ya >= game.getHeight() - diameter) {
            if (game.bar.lives == 0) {
                game.gameOver();
            } else if (game.bar.lives > 0) {
                Bar.looseLive(game);
            }
        } else if (collisionWithBricks()) {  //проверка столкновения с платформой Bar
            if (ultraBallMode) {
                game.brick.bricksLine.remove(brick);
            } else {
                ballTopPosition = y;
                ballBottomPosition = y + diameter;
                ballRightPosition = x + diameter + 14;
                ballLeftPosition = x;

                brickTopPosition = game.brick.bricksLine.get(brick).y + 1;
                brickBottomPosition = game.brick.bricksLine.get(brick).y + Bricks.Brick.height - 1;
                brickRightPosition = game.brick.bricksLine.get(brick).x + 14;
                brickLeftPosition = game.brick.bricksLine.get(brick).x + Bricks.Brick.width;

                // изменения направления полета меча

                if ((ballBottomPosition == brickTopPosition || ballTopPosition == brickBottomPosition) &&
                        (ballRightPosition != brickLeftPosition && ballLeftPosition != brick)) {
                    if (ya == 1) {
                        ya = -1;
                    } else if (ya == -1) {
                        ya = 1;
                    }
                } else {
                    if (xa > 0) {
                        xa *= -1;
                    } else if (xa < 0) {
                        xa *= -1;
                    }

                    // удаление блоков сли необходимо (после ударов)
                    if (game.brick.bricksLine.get(brick).hits == 0) {
                        game.brick.bricksLine.remove(brick);
                    } else {
                        game.brick.updateHits(brick);
                    }

                    // если все блоки были уничтожены (удалены)
                    if (game.brick.bricksLine.size() == 0) {
                        Levels.startNewLevel(game);
                    }
                }
                // проапдейтить направление движения меча
                x = x + xa;
                y = y + ya;
            }
        }
    }

    private boolean collisionWithBar() {
        return true;
    } // расписать реализацию метода

    private boolean collisionWithBricks() {
        return true;
    } // расписать реализацию метода

    private boolean collisionWithBounds() {
        return true;
    } // расписать реализацию метода

    public void paintBall(Graphics2D graphics) {
        graphics.setColor(Color.BLUE);
        if (bigBallMode) {
            if (bigBallModeColor == 0) {
                graphics.setColor(Color.RED);
                bigBallModeColor++;
            } else if (bigBallModeColor == 1) {
                graphics.setColor(Color.WHITE);
                bigBallModeColor++;
            } else if (bigBallModeColor == 2) {
                graphics.setColor(Color.GREEN);
                bigBallModeColor = 0;
            }
            graphics.fillOval(x, y, diameter, diameter);
        } else if (fireBallMode) {
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }
}
