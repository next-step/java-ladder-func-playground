package model;

import java.util.ArrayList;
import java.util.List;

public class PointGenerator {
    private final RandomUtil randomUtil;

    public PointGenerator(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
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
        int randomIndex = randomUtil.generateRandomNumber();
        return points.get(randomIndex);
    }
}
