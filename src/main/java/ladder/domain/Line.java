package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line from(int size, BooleanSupplier strategy) {
        return new Line(generatePoints(size, strategy));
    }

    public List<Point> getPoints() {
        return points;
    }

    public int move(int index) {
        if (index < points.size() && points.get(index).hasBridge()) {
            return index + 1;
        }
        if (index > 0 && points.get(index - 1).hasBridge()) {
            return index - 1;
        }
        return index;
    }

    private static List<Point> generatePoints(int size, BooleanSupplier strategy) {
        List<Point> points = new ArrayList<>();
        boolean lastBridge = false;
        for (int i = 0; i < size; i++) {
            lastBridge = addPoint(points, lastBridge, strategy);
        }
        return points;
    }

    private static boolean addPoint(List<Point> points, boolean lastBridge, BooleanSupplier strategy) {
        boolean currentBridge = !lastBridge && strategy.getAsBoolean();
        points.add(Point.from(currentBridge));
        return currentBridge;
    }
}
