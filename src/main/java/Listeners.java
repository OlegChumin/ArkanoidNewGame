import java.awt.event.*;

// класс Listener написан

public class Listeners {
    private Arkanoid game;
    public static final int LEFT = 37; // надо проверить при отладке
    public static final int RIGHT = 39; // надо проверить при отладке

    int old_width = 0; // счетчик изменения ширины

    public Listeners(Arkanoid game) {
        this.game = game;
        KeyListener keyListener = new MyKeyListener(); // здесь создаем объект для отслеживания лево и
        // право стрелок клавиатуры
        MouseMotionListener mouseMotionListener = new MyMouseMotionListener();
        MouseListener mouseListener = new MyMouseListener();
        game.addKeyListener(keyListener); // передаем объект в игру game
        game.addMouseMotionListener(mouseMotionListener);
        game.addMouseListener(mouseListener);
    }

    public class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // здесь реализации у нас не будет
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == LEFT) {
                game.bar.move(LEFT);
            } else if (e.getKeyCode() == RIGHT) {
                game.bar.move(RIGHT);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // здесь реализации у нас не будет
        }
    }

    public class MyMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // доска - бита - платформа следует за указателем mouse
            game.bar.x = e.getX() - (Bar.WIDTH / 2);
        }
    }

    public class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Arkanoid.startGame(game);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
            // это метод не используем
        }
    }
}
