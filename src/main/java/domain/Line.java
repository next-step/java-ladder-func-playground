package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;

    public Line(int width, Random random) {
        this.points = generateLine(width, random);
    }

    private List<Point> generateLine(int width, Random random) {
        List<Point> result = new ArrayList<>();
        boolean previous = false;

        for (int i = 0; i < width - 1; i++) {
            boolean connect = !previous && random.nextBoolean();
            result.add(new Point(connect));
            previous = connect;
        }

        result.add(new Point(false));
        return result;
    }

    public List<Point> points() {
        return points;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Point point : points) {
            builder.append(point);
        }
        builder.append("|");
        return builder.toString();
    }
}
