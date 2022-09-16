import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bricks {
//    {
//        int[] array = new int[10];
//        array[6] = 10;
//    }
//
////    0  1 2 ....              array.length() - 1
////    [][][][][][]]][][][][][][]

    public ArrayList<ArrayList<Brick>> brickRow = new ArrayList<>();
    public List<Brick> bricks = new ArrayList<>();

    private Arkanoid game;

    public Bricks(Arkanoid game) {
        this.game = game;
    }

    public static class Brick {
        private static final int WIDTH = 15;
        public static final int HEIGHT = 10;
        int x = 15;
        int y = 50;

        Color color = Color.BLACK;
        int hits = 1;

    }

    public void paint(Graphics2D graphics) {
        for (int i = 0; i < 0; i++) {
            for (int j = 0; j < 0; j++) {

            }
        }
    }


}
