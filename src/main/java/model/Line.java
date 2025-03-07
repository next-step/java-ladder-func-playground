package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;
    private final Random random = new Random();

    public Line(Size width) {
        this.points = createLinePoints(width);
    }

    private List<Point> createLinePoints(Size width) {
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

    public List<Point> getPoints() {
        return List.copyOf(points);
    }
}
