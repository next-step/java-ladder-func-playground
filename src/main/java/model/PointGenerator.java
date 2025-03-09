package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointGenerator {
    private final Random random;

    public PointGenerator(Random random) {
        this.random = random;
    }

    public List<Point> createLinePoints(Size width) {
        List<Point> points = new ArrayList<>();
        boolean isPreviousLine = false;

        for (int i = 1; i < width.getSize(); i++) {
            Point point = createPoint(isPreviousLine);
            points.add(point);
            isPreviousLine = (point == Point.HAS_POINT);
        }
        return List.copyOf(points);
    }

    private Point createPoint(boolean isPreviousLine) {
        List<Point> points = List.of(Point.NO_POINT, Point.HAS_POINT);
        if (isPreviousLine) {
            return Point.NO_POINT;
        }
        int randomIndex = random.nextInt(points.size());
        return points.get(randomIndex);
    }
}
