package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points;
    private final Random random = new Random();

    public Line(int width) {
        this.points = generatePoints(width);
    }

    private List<Boolean> generatePoints(int width) {
        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < width - 1; i++) {
            if (i > 0 && points.get(i - 1)) {
                points.add(false);
            } else {
                points.add(random.nextBoolean());
            }
        }

        return points;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
