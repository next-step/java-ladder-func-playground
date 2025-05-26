package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line generate(int width) {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;

        Random random = new Random();
        for (int i = 0; i < width; i++) {
            boolean current = !previous && random.nextBoolean();
            points.add(current);
            previous = current;
        }

        return new Line(points);
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
