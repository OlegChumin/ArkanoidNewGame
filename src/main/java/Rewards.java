import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
        int num = (int) Math.floor(Math.random() * (game.brick.bricksLine.size() - 1) + 1);
    }

    Arkanoid game;

    public class Reward {
        int x, y;
        int width, height;
        String type;
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
            if (game.brick.bricksLine.get(random.num).reward_type == "") {
                game.brick.bricksLine.get(random.num).reward_type = "UltraBall";
                rewardUltraBallNum--;
            }
        }

        while (rewardBigBallNum > 0) {
            Random random = new Random();
            if (game.brick.bricksLine.get(random.num).reward_type == "") {
                game.brick.bricksLine.get(random.num).reward_type = "BigBall";
                rewardBigBallNum--;
            }
        }

        while (rewardSmallBallNum > 0) {
            Random random = new Random();
            if (game.brick.bricksLine.get(random.num).reward_type == "") {
                game.brick.bricksLine.get(random.num).reward_type = "SmallBall";
                rewardSmallBallNum--;
            }
        }

        while (rewardBigBarNum > 0) {
            Random random = new Random();
            if (game.brick.bricksLine.get(random.num).reward_type == "") {
                game.brick.bricksLine.get(random.num).reward_type = "BigBar";
                rewardBigBarNum--;
            }
        }

        while (rewardSmallBarNum > 0) {
            Random random = new Random();
            if (game.brick.bricksLine.get(random.num).reward_type == "") {
                game.brick.bricksLine.get(random.num).reward_type = "SmallBar";
                rewardBigBallNum--;
            }
        }

        while (rewardExtraLiveNum > 0) {
            Random random = new Random();
            if (game.brick.bricksLine.get(random.num).reward_type == "") {
                game.brick.bricksLine.get(random.num).reward_type = "ExtraLive";
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

    }

    public void stopReward() {

    }

    public void stopAllRewards() {

    }

    public void paintBrickReward(Graphics2D graphics) {

    }

    public void paintReward() {

    }

    public void paint(Graphics2D graphics) {

    }

    public Rectangle getBount(int i) {
        return new Rectangle(current_rewards.get(i).x, current_rewards.get(i).y,
                current_rewards.get(i).width, current_rewards.get(i).height);
    }

    private boolean barCollisson(int i) {
        return true; // дописать метод
    }

}
