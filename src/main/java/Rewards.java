import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Rewards {
    public static int ultraBall_time = 10;
    public int default_reward_ultraBall_num = 3;
    public int default_reward_bigBall = 3;
    public int default_reward_smallBall = 2;
    public int default_reward_bigBar_num = 3;
    public int default_reward_smallBar_num = 2;
    public int default_reward_extraLive_num = 1;
    int rewardUltraBallNum = default_reward_ultraBall_num;
    int rewardBigBallNum = default_reward_bigBall;
    int rewardSmallBallNum = default_reward_smallBall;
    int rewardBigBarNum = default_reward_bigBar_num;
    int rewardSmallBarNum = default_reward_smallBar_num;
    int rewardExtraLiveNum = default_reward_extraLive_num;

    private class Random {
        int num = (int) Math.floor(Math.random()*(game.brick.bricksLine.size()-1) + 1);
    }

    Arkanoid game;

    public class Reward {
        int x, y;
        int with, height;
        String type;
        boolean rewardBrickOn = false;
        boolean rewardOn = false;
    }

    Reward current_reward = new Reward();

    public static List<Reward> current_rewards = new ArrayList<>();

    public void createAllRewards() {

    }

    public void createReward(String type, int x, int y) {

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
                current_rewards.get(i).with, current_rewards.get(i).height);
    }

    private boolean barCollisson(int i) {
        return true; // дописать метод
    }

    public Rewards(Arkanoid game) {
        this.game = game;
    }
}
