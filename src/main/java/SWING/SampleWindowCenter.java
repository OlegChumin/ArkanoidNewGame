package SWING;

import javax.swing.*;
import java.awt.*;

public class SampleWindowCenter {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 400;


    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Новый заголовок нашего окна");
//        jFrame.setTitle("Новый заголовок нашего окна");
        jFrame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension ourScreenDimension = toolkit.getScreenSize();
        jFrame.setBounds(ourScreenDimension.width / 2 - WINDOW_WIDTH / 2,
                ourScreenDimension.height / 2 - WINDOW_HEIGHT / 2,
                WINDOW_WIDTH, WINDOW_HEIGHT);
//        jFrame.setLocation(500, 400);
//        jFrame.setSize(500, 400);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
