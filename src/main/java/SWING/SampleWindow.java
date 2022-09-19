package SWING;

import javax.swing.*;

public class SampleWindow {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Новый заголовок нашего окна");
//        jFrame.setTitle("Новый заголовок нашего окна");
        jFrame.setVisible(true);
        jFrame.setLocation(500, 400);
        jFrame.setSize(500, 400);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
