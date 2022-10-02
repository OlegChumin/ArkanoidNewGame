import javax.swing.*;
import java.awt.*;

public class Text {
    public static int menu_bar_height = 25;
    Arkanoid game;

    public Text(Arkanoid game) {
        this.game = game;
    }

    JLabel start_label = new JLabel("Level " + Levels.current_level + "Click to start", SwingConstants.CENTER);
    JLabel rewards_label = new JLabel("", SwingConstants.CENTER);
    JLabel lives_text_label = new JLabel("||| Lives: ");
    JLabel lives_label = new JLabel("");
    JLabel level_label = new JLabel("LEVEL " + Levels.current_level, SwingConstants.CENTER);
    Font levelToStartFont = new Font("courier", Font.PLAIN, 13);
    Font rewardsFont = new Font("courier", Font.BOLD, 17);
    Font levelFont = new Font("courier", Font.BOLD, 13);

    void makeStartLabel() {
        start_label.setVisible(true);
        start_label.setBounds(0, 155, Arkanoid.WIDTH, 100);
        start_label.setFont(levelToStartFont);
        start_label.setForeground(Color.GREEN);
        game.add(start_label);
    }

    void makeRewardsLabel() {
        // расписать класс
    }

    void makeLivesLabel() {
        lives_text_label.setVisible(true);
        lives_text_label.setBounds(Arkanoid.WIDTH-103, -33, Arkanoid.WIDTH, 100);
        lives_label.setBounds(Arkanoid.WIDTH - 22, -33, Arkanoid.WIDTH, 100);
        lives_text_label.setFont(levelToStartFont);
        lives_label.setFont(levelToStartFont);
        lives_text_label.setForeground(Color.WHITE);
        lives_label.setForeground(Color.GREEN);
        game.add(lives_text_label);
        lives_text_label.setText("" + game.bar.lives);
        game.add(lives_label);
    }

    public void paint(Graphics2D graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 5, Arkanoid.WIDTH, 2);
        graphics.fillRect(0, menu_bar_height, Arkanoid.WIDTH, 2);
        makeLivesLabel();
    }

}
