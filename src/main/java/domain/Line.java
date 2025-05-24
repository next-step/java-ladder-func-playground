package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(int width) {
        List<Point> points = new ArrayList<>();
        Random random = new Random();
        boolean previousConnected = false;

        for (int i = 0; i < width - 1; i++) {
            boolean connect = !previousConnected && random.nextBoolean();
            points.add(Point.of(connect));
            previousConnected = connect;
        }
        points.add(Point.of(false));
        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}
