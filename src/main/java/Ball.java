import java.awt.*;

/**
 * Ball responsible for all kind of balls in the game
 */

public class Ball {
    public static int diameter = 10;
    public static int default_x = 205;
    public static int default_y = 350;

    int x = default_x;
    int y = default_y;

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

    public static boolean ultraBallMode = false;
    public static int ultraBallColor = 0;
    //    public static boolean bigBallMode = false;
    //    public static int bigBallModeColor = 0;
//    public static boolean fireBallMode = false;
//    public static int fireBallModeColor = 5; //дописать в код

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
        } else if (collision()) {//проверка столкновения с платформой Bar
            ya = -1;
            y = game.bar.getTopY() - diameter + 10;
        } else if (collisionWithBricks()) {  // проверка столкновения с блоками
            if (ultraBallMode) {
                game.brick.bricks.remove(brick);
            } else {
                ballTopPosition = y;
                ballBottomPosition = y + diameter;
                ballRightPosition = x + diameter + 14;
                ballLeftPosition = x;

                brickTopPosition = game.brick.bricks.get(brick).y + 1;
                brickBottomPosition = game.brick.bricks.get(brick).y + Bricks.Brick.height - 1;
                brickRightPosition = game.brick.bricks.get(brick).x + 14;
                brickLeftPosition = game.brick.bricks.get(brick).x + Bricks.Brick.width;

                // изменения направления полета меча

                if ((ballBottomPosition == brickTopPosition || ballTopPosition == brickBottomPosition) && (ballRightPosition != brickLeftPosition && ballLeftPosition != brick)) {
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
                    if (game.brick.bricks.get(brick).hits == 0) {
                        game.brick.bricks.remove(brick);
                    } else {
                        game.brick.updateHits(brick);
                    }

                    // если все блоки были уничтожены (удалены)
                    if (game.brick.bricks.size() == 0) {
                        Levels.startNewLevel(game);
                    }
                }
                // изменение направление движения меча
                x = x + xa;
                y = y + ya;
            }
        }
    }

    private boolean collision() { // надо проверить
        if (game.bar.getBounds().intersects(getBounds())) {
            return true;
        } else if (game.bar.getBoundsLeft().intersects(getBounds())) {
            if (xa > 0) {
                xa *= -1;
                if (x * xa < 0 && xa + 1 != 0) {
                    xa++;
                }
                if (game.speed < 10) {
                    game.speed += 1;
                }
            } else if (xa < 0) {
                if (x * xa < 0 && xa - 1 != 0) {
                    xa--;
                }
                if (game.speed > 2) {
                    game.speed -= 1;
                }
            }
            return true;
        } else if (game.bar.getBoundsRight().intersects(getBounds())) {
            if (xa < 0) {
                xa *= -1;
                if (x * xa > 0 && xa - 1 != 0) {
                    xa--;
                }
                if (game.speed < 10) {
                    game.speed += 1;
                }
            } else if (xa > 0) {
                if (x * xa > 0 && xa + 1 != 0) {
                    xa++;
                }
                if (game.speed > 2) {
                    game.speed -= 1;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean collisionWithBricks() {
        for (int i = 0; i < game.brick.bricks.size(); i++) {
            if (game.brick.bricks.get(i).getBounds().intersects(getBounds())) {
                brick = i;
                // если блок имееет внутри приз (reward), то мы создаем приз (reward)
                if (game.brick.bricks.get(i).hasRewards()) {
                    game.rewards.createReward(game.brick.bricks.get(i).reward_type, game.brick.bricks.get(i).x - 3, game.brick.bricks.get(i).y);
                }
                return game.brick.bricks.get(i).getBounds().intersects(getBounds());
            }
        }
        return false;
    }

    public void paintBall(Graphics2D graphics) {
        graphics.setColor(Color.BLUE);
        if (ultraBallMode) {
            if (ultraBallColor == 0) {
                graphics.setColor(Color.RED);
                ultraBallColor++;
            } else if (ultraBallColor == 1) {
                graphics.setColor(Color.WHITE);
                ultraBallColor++;
            } else if (ultraBallColor == 2) {
                graphics.setColor(Color.GREEN);
                ultraBallColor = 0;
            }
            graphics.fillOval(x, y, diameter, diameter);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }
}
