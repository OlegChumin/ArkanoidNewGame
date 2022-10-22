import java.awt.*;
import java.util.ArrayList;
import java.util.List;
// предварительно код класса Rewards написан
public class Rewards {
    public static int ultraBall_time = 10;
    public int default_reward_ultraBall_num = 3;
    public int default_reward_bigBall_num = 3;
    public int default_reward_smallBall_num = 2;
    public int default_reward_bigBar_num = 3;
    public int default_reward_smallBar_num = 2;
    public int default_reward_extraLive_num = 1;
    int rewardUltraBallNum = default_reward_ultraBall_num; // приз Ультра шар
    int rewardBigBallNum = default_reward_bigBall_num; // приз большой шар
    int rewardSmallBallNum = default_reward_smallBall_num; // приз малый шар
    int rewardBigBarNum = default_reward_bigBar_num; // приз малая платформа
    int rewardSmallBarNum = default_reward_smallBar_num; // приз большая платформа
    int rewardExtraLiveNum = default_reward_extraLive_num; // приз дополнительная жизнь

    private class Random {
        int num = (int) Math.floor(Math.random() * (game.brick.bricks.size() - 1) + 1);
    }

    Arkanoid game;

    public class Reward {
        int x, y;
        int width, height;
        String type; // поле отвечающее за тип приза (достижения) в игре
        boolean rewardBrickOn = false;
        boolean rewardOn = false;
    }

    Reward current_reward = new Reward();

    public static List<Reward> current_rewards = new ArrayList<>();

    public Rewards(Arkanoid game) {
        this.game = game;
    }

    public void createAllRewards() {
        // создаем все достижения (награды, призы) на стартовом уровне. Устанавливаем произвольную (random)
        // позицию по rewards в каждом уровне
        while (rewardUltraBallNum > 0) {
            Random random = new Random();
            if (game.brick.bricks.get(random.num).reward_type == "") {
                game.brick.bricks.get(random.num).reward_type = "UltraBall";
                rewardUltraBallNum--;
            }
        }

        while (rewardBigBallNum > 0) {
            Random random = new Random();
            if (game.brick.bricks.get(random.num).reward_type == "") {
                game.brick.bricks.get(random.num).reward_type = "BigBall";
                rewardBigBallNum--;
            }
        }

        while (rewardSmallBallNum > 0) {
            Random random = new Random();
            if (game.brick.bricks.get(random.num).reward_type == "") {
                game.brick.bricks.get(random.num).reward_type = "SmallBall";
                rewardSmallBallNum--;
            }
        }

        while (rewardBigBarNum > 0) {
            Random random = new Random();
            if (game.brick.bricks.get(random.num).reward_type == "") {
                game.brick.bricks.get(random.num).reward_type = "BigBar";
                rewardBigBarNum--;
            }
        }

        while (rewardSmallBarNum > 0) {
            Random random = new Random();
            if (game.brick.bricks.get(random.num).reward_type == "") {
                game.brick.bricks.get(random.num).reward_type = "SmallBar";
                rewardBigBallNum--;
            }
        }

        while (rewardExtraLiveNum > 0) {
            Random random = new Random();
            if (game.brick.bricks.get(random.num).reward_type == "") {
                game.brick.bricks.get(random.num).reward_type = "ExtraLive";
                rewardExtraLiveNum--;
            }
        }
        rewardUltraBallNum = default_reward_ultraBall_num; // почему здесь я опять присвоил defaul значения
        rewardBigBallNum = default_reward_bigBall_num;
        rewardSmallBallNum = default_reward_smallBall_num;
        rewardBigBarNum = default_reward_bigBar_num;
        rewardSmallBarNum = default_reward_smallBar_num;
        rewardExtraLiveNum = default_reward_extraLive_num;
    }

    public void createReward(String type, int x, int y) {
        Reward reward = new Reward();
        reward.type = type;
        reward.x = x;
        reward.y = y;
        current_reward = reward;
        current_reward.rewardBrickOn = true;
        if (type == "UltraBall") {
            reward.width = Bricks.Brick.width + 6;
            reward.height = Bricks.Brick.height;
        } else if (type == "BigBall") {
            reward.width = Bricks.Brick.width + 5;
            reward.height = Bricks.Brick.height + 5;
        } else if (type == "SmallBall") {
            reward.width = Bricks.Brick.width - 8;
            reward.height = Bricks.Brick.height - 8;
        } else if (type == "BigBar" || type == "SmallBar") {
            reward.width = Bricks.Brick.width + 5;
            reward.height = Bricks.Brick.height - 2;
        } else if (type == "ExtraLive") {
            reward.width = Bricks.Brick.width + 6;
            reward.height = Bricks.Brick.height;
        }
        current_rewards.add(current_reward);
    }

    public void startReward(String type) {
        Arkanoid.time_counter = 0; // а надо ли еще раз присваивать нуль?
        for (int i = 0; i < current_rewards.size(); i++) {
            if (current_rewards.get(i).type == "UltraBall" && type == current_rewards.get(i).type) {
                current_rewards.get(i).rewardBrickOn = false;
                current_rewards.get(i).rewardOn = true;
                Ball.ultraBallMode = true;
                ultraBall_time = 10; // проверить число при code review
            } else if (current_rewards.get(i).type == "BigBall" && type == current_rewards.get(i).type) {
                current_rewards.remove(current_rewards.get(i));
                if (Ball.diameter == 5) {
                    Ball.diameter += 5;
                } else {
                    Ball.diameter += 10;
                }
            } else if (current_rewards.get(i).type == "SmallBall" && type == current_rewards.get(i).type) {
                current_rewards.remove(current_rewards.get(i));
                if (Ball.diameter <= 10 && Ball.diameter > 5) {
                    Ball.diameter -= 5;
                } else if (Ball.diameter > 10) {
                    Ball.diameter -= 10;
                }
            } else if (current_rewards.get(i).type == "BigBar" && type == current_rewards.get(i).type) {
                current_rewards.remove(current_rewards.get(i));
                if (Bar.barWidth == 15) {
                    Bar.barWidth += 15;
                    Bar.barSideWidth += 5;
                    Bar.bar_main_color = Color.WHITE;
                    Bar.bar_side_color = Color.GRAY;
                } else {
                    Bar.barWidth += 15;
                    Bar.bar_main_color = Color.CYAN;
                    Bar.bar_side_color = Color.BLUE;
                }
            } else if (current_rewards.get(i).type == "SmallBar" && type == current_rewards.get(i).type) {
                current_rewards.remove(current_rewards.get(i));
                if (Bar.barWidth == 30) {
                    Bar.barWidth -= 15;
                    Bar.barSideWidth -= 5;
                    Bar.bar_main_color = Color.WHITE;
                    Bar.bar_side_color = Color.BLUE;
                } else if (Bar.barWidth == 45) {
                    Bar.barWidth -= 15;
                    Bar.bar_main_color = Color.WHITE;
                    Bar.bar_side_color = Color.GRAY;
                }
            } else if (current_rewards.get(i).type == "ExtraLive" && type == current_rewards.get(i).type) {
                current_rewards.remove(current_rewards.get(i));
                game.bar.lives++; // добавляет 1 жизнь или + 1 bar
            }
        }
    }

    public void stopReward(String type) {
        if ("UltraBall".equals(type)) {
            for (int i = 0; i < current_rewards.size(); i++) {
                if (type == current_rewards.get(i).type) {
                    Ball.ultraBallMode = false;
                    current_rewards.get(i).rewardOn = false;
                    game.text.rewards_label.setText("");
                    current_rewards.remove(current_rewards.get(i));
                } else if (type == "BigBall" || type == "SmallBall") {
                    Ball.diameter = 10;
                } else if ("BigBar".equals(type) || "SmallBar".equals(type)) {
                    Bar.barWidth = 30;
                    Bar.barSideWidth = 20;
                    Bar.bar_main_color = Color.WHITE;
                    Bar.bar_side_color = Color.GRAY;
                }
            }
        }
    }

    public void stopAllRewards() {
        stopReward("UltraBall");
        stopReward("BigBall");
        stopReward("SmallBall");
        stopReward("BigBar");
        stopReward("SmallBar");
    }

    public void paintBrickReward(Graphics2D graphics) {
        for (int i = 0; i < current_rewards.size(); i++) {
            if ("UltraBall".equals(current_rewards.get(i).type) && current_rewards.get(i).rewardBrickOn) {
                if (Ball.ultraBallColor == 0) {
                    graphics.setColor(Color.RED);
                    Ball.ultraBallColor++;
                } else if (Ball.ultraBallColor == 1) {
                    graphics.setColor(Color.YELLOW);
                    Ball.ultraBallColor++;
                } else if (Ball.ultraBallColor == 2) {
                    graphics.setColor(Color.GREEN);
                    Ball.ultraBallColor = 0;
                }
                graphics.fillRoundRect(current_rewards.get(i).x, current_rewards.get(i).y, current_rewards.get(i).width,
                        current_rewards.get(i).height, 10, 10);
            } else if ("BigBall".equals(current_rewards.get(i).type) && current_rewards.get(i).rewardBrickOn) {
                graphics.setColor(Color.WHITE);
                graphics.fillRoundRect(current_rewards.get(i).x, current_rewards.get(i).y, current_rewards.get(i).width,
                        current_rewards.get(i).height, 100, 100);
            } else if ("SmallBall".equals(current_rewards.get(i).type) && current_rewards.get(i).rewardBrickOn) {
                graphics.setColor(Color.WHITE);
                graphics.fillRoundRect(current_rewards.get(i).x, current_rewards.get(i).y, current_rewards.get(i).width,
                        current_rewards.get(i).height, 100, 100);
            } else if ("BigBar".equals(current_rewards.get(i).type) && current_rewards.get(i).rewardBrickOn) {
                graphics.setColor(Color.CYAN);
                graphics.fillRoundRect(current_rewards.get(i).x, current_rewards.get(i).y, current_rewards.get(i).width,
                        current_rewards.get(i).height, 10, 10);
                graphics.setColor(Color.WHITE);
                graphics.setFont(new Font("SansSerif", Font.BOLD, 10));
                graphics.drawString(">        <", current_rewards.get(i).x + 7, current_rewards.get(i).y + 7);
            } else if ("SmallBar".equals(current_rewards.get(i).type) && current_rewards.get(i).rewardBrickOn) {
                graphics.setColor(Color.CYAN);
                graphics.fillRoundRect(current_rewards.get(i).x, current_rewards.get(i).y, current_rewards.get(i).width,
                        current_rewards.get(i).height, 10, 10);
                graphics.setColor(Color.WHITE);
                graphics.setFont(new Font("SansSerif", Font.BOLD, 10));
                graphics.drawString(">        <", current_rewards.get(i).x + 7, current_rewards.get(i).y + 7);
            } else if ("ExtraLive".equals(current_rewards.get(i).type) && current_rewards.get(i).rewardBrickOn) {
                graphics.setColor(Color.PINK);
                graphics.fillRoundRect(current_rewards.get(i).x, current_rewards.get(i).y, 8,
                        8, 100, 100);
                graphics.fillRoundRect(current_rewards.get(i).x + 8, current_rewards.get(i).y, 8,
                        8, 100, 100);
                int xPoints[] = {current_rewards.get(i).x, current_rewards.get(i).x + 8, current_rewards.get(i).x + 16};
                int yPoints[] = {current_rewards.get(i).y + 4, current_rewards.get(i).y + 15, current_rewards.get(i).y + 4};
                int nPoints = 3;
                graphics.fillPolygon(xPoints, yPoints, nPoints);
            }
        }
    }

    public void paintReward() {
        for (int i = 0; i < current_rewards.size(); i++) {
            if (current_rewards.get(i).rewardOn) {
                if ("UltraBall".equals(current_rewards.get(i).type)) {
                    if (ultraBall_time == 0) {
                        stopReward("UltraBall");
                    }
                    if (ultraBall_time > 0) {
                        game.text.rewards_label.setText("" + ultraBall_time);
                        ultraBall_time--;
                    }
                }
            }
        }
    }

    public void paint(Graphics2D graphics) {
        for (int i = 0; i < current_rewards.size(); i++) {
            if (current_rewards.get(i).rewardBrickOn) {
                if (!barCollisson(i)) {
                    paintBrickReward(graphics);
                    if (current_rewards.get(i).y == Arkanoid.HEIGHT) {
                        current_rewards.remove(current_rewards.get(i));
                    } else {
                        current_rewards.get(i).y++;
                    }
                } else if (barCollisson(i)) {
                    startReward(current_rewards.get(i).type);
                }
            }
        }
    }

    public Rectangle getBounds(int i) {
        return new Rectangle(current_rewards.get(i).x, current_rewards.get(i).y,
                current_rewards.get(i).width, current_rewards.get(i).height);
    }

    private boolean barCollisson(int i) {
        if (game.bar.getBounds().intersects(getBounds(i))) {
            return true;
        } else if (game.bar.getBoundsLeft().intersects(getBounds(i))) {
            return true;
        } else if (game.bar.getBoundsRight().intersects(getBounds(i))) {
            return true;
        } else {
            return false;
        }
    }
}
