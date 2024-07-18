package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final Random random = new Random();
    private final List<Boolean> points = new ArrayList<>();
    private final int width;

    public Line(int width) {
        this.width = width;
        generateLine();
    }

    private void generateLine() {
        for (int i = 0; i < width - 1; i++) {
            points.add(random.nextBoolean());
            checkLeft(i);
        }
    }

    private void checkLeft(int i) {
        if (i > 0 && points.get(i - 1).equals(points.get(i))) {
            points.set(i, !points.get(i));
        }
    }

    public List<Boolean> getLine() {
        return points;
    }

    public int getWidth() {
        return width;
    }
}
