package SWING;

import javax.swing.*;
import java.awt.*;

public class DrawFigures {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 400;


    public static void main(String[] args) {
        JFrame newWindow = buildWindow();
        newWindow.add(new MyComponent());
        getSystemFonts();
    }

    private static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Font font = new Font("Ariel", Font.BOLD, 25);
            Graphics2D g2 = (Graphics2D) g;
            String str = "Hallo GameDev2D group!";
            g2.setFont(font);
            g2.drawString(str, 20, 30);
        }
    }

    private static JFrame buildWindow() {
        JFrame jFrame = new JFrame("Рисуем фигуры в окне");
        jFrame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension ourScreenDimension = toolkit.getScreenSize();
        jFrame.setBounds(ourScreenDimension.width / 2 - WINDOW_WIDTH / 2,
                ourScreenDimension.height / 2 - WINDOW_HEIGHT / 2,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }

    private static void getSystemFonts() {
       String[] arrayOfFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (String element: arrayOfFonts) {
            System.out.println(element);
        }
    }

}
