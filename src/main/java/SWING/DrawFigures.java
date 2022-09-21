package SWING;

import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawFigures {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 400;


    public static void main(String[] args) {
        JFrame newWindow = buildWindow();
        newWindow.add(new MyComponent());
//        getSystemFonts();
    }

    private static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics g) {
            Font font = new Font("Ariel", Font.BOLD, 25);
            Graphics2D g2 = (Graphics2D) g;
            String str = "Hallo GameDev2D group!";
            g2.setFont(font);
            g2.drawString(str, 20, 30);

            //рисуем линии
            Line2D newLine1 = new Line2D.Double(70, 70, 90, 90);
            Line2D newLine2 = new Line2D.Double(90, 90, 110, 70);
            Line2D newLine3 = new Line2D.Double(110, 70, 130, 90);
            Line2D newLine4 = new Line2D.Double(130, 90, 150, 70);
            Line2D newLine5 = new Line2D.Double(150, 70, 170, 90);
            g2.draw(newLine1);
            g2.draw(newLine2);
            g2.draw(newLine3);
            g2.draw(newLine4);
            g2.draw(newLine5);
            g2.setColor(Color.BLACK);

            // рисуем эллипс и круг
            Ellipse2D ellipse2D = new Ellipse2D.Double(100, 100, 150, 70);
            g2.draw(ellipse2D);

            Ellipse2D circle = new Ellipse2D.Double(200, 200, 150, 150);
            g2.draw(circle);
            g2.setColor(Color.getHSBColor(100, 150, 230));
            g2.fill(circle);

            Rectangle2D rectangle2D = new Rectangle2D.Double(100, 100, 300, 300);
            g2.setColor(Color.BLACK);
            g2.draw(rectangle2D);


            //Д.з.
            double x1, x2, y1, y2;
            Line2D newLine;


//            for (int i = 0; i < 100; i++) {
////                x1 = F(i);
////                x2 = F(x1);
////                y1 = F(i);
////                y2 = F(y1);
//                g2.draw(new Line2D.Double(x1, y1, x2, y2));
//            }
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

}
