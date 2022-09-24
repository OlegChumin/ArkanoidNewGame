package SWING;

import sun.print.PeekGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class DrawFigures {
    private static final int WINDOW_WIDTH = 411;
    private static final int WINDOW_HEIGHT = 451;

    private static final int BAR_HEIGHT_LEVEL = 30;


    public static void main(String[] args) {
        JFrame newWindow = buildWindow();
        newWindow.add(new MyComponent());
//        getSystemFonts();
    }

    private static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
//            Font font = new Font("Ariel", Font.BOLD, 25);
            Graphics2D g2 = (Graphics2D) g;
//            String str = "Hallo GameDev2D group!";
//            g2.setFont(font);
//            g2.drawString(str, 20, 30);

            //рисуем линии
            Line2D verticalLine = new Line2D.Double(WINDOW_WIDTH / 2, 0, WINDOW_WIDTH / 2, WINDOW_HEIGHT);
            Line2D horizontalLine = new Line2D.Double(0, WINDOW_HEIGHT / 2 - 20, WINDOW_WIDTH, WINDOW_HEIGHT / 2 - 20);
//            Line2D newLine3 = new Line2D.Double(110, 70, 130, 90);
//            Line2D newLine4 = new Line2D.Double(130, 90, 150, 70);
//            Line2D newLine5 = new Line2D.Double(150, 70, 170, 90);
            g2.draw(verticalLine);
            g2.draw(horizontalLine);
//            g2.draw(newLine3);
//            g2.draw(newLine4);
//            g2.draw(newLine5);
//            g2.setColor(Color.BLACK);

            // рисуем эллипс и круг
//            Ellipse2D ellipse2D = new Ellipse2D.Double(100, 100, 150, 70);
//            g2.draw(ellipse2D);
//
//            Ellipse2D circle = new Ellipse2D.Double(200, 200, 150, 150);
//            g2.draw(circle);
//            g2.setColor(Color.getHSBColor(100, 150, 230));
//            g2.fill(circle);
//
//            Rectangle2D rectangle2D = new Rectangle2D.Double(100, 100, 300, 300);
//            restColorToOriginBlack(g2);
//            g2.draw(rectangle2D);

            RoundRectangle2D barLeftSide = new RoundRectangle2D.Double(WINDOW_WIDTH / 2 - 30 / 2 - 20, WINDOW_HEIGHT / 2 - 10 / 2 - 20, 30, 10, 10, 10);
            g2.setColor(Color.RED);
            g2.draw(barLeftSide);
            g2.fill(barLeftSide);
            restColorToOriginBlack(g2);

            RoundRectangle2D barRightSide = new RoundRectangle2D.Double(WINDOW_WIDTH / 2 - 30 / 2 + 20, WINDOW_HEIGHT / 2 - 10 / 2 - 20, 30, 10, 10, 10);
            g2.setColor(Color.RED);
            g2.draw(barRightSide);
            g2.fill(barRightSide);
            restColorToOriginBlack(g2);

            RoundRectangle2D barCentralPart = new RoundRectangle2D.Double(WINDOW_WIDTH / 2 - 30 / 2, WINDOW_HEIGHT / 2 - 10 / 2 - 20, 30, 10, 0, 0);
            g2.setColor(Color.BLUE);
            g2.draw(barCentralPart);
            g2.fill(barCentralPart);
            restColorToOriginBlack(g2);

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
        for (String element : arrayOfFonts) {
            System.out.println(element);
        }
    }

    private static void restColorToOriginBlack(Graphics2D g2) {
        g2.setColor(Color.BLACK);
    }

}
