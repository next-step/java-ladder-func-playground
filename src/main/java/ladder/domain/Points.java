package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Points implements Iterable<Point> {
    private final List<Point> points;

    private Points(List<Point> points) {
        this.points = points;
    }

    public static Points generate(int size, BooleanSupplier strategy) {
        List<Point> points = new ArrayList<>();
        boolean lastBridge = false;
        for (int i = 0; i < size; i++) {
            lastBridge = addPoint(points, lastBridge, strategy);
        }
        return new Points(points);
    }

    private static boolean addPoint(List<Point> points, boolean lastBridge, BooleanSupplier strategy) {
        boolean currentBridge = !lastBridge && strategy.getAsBoolean();
        points.add(Point.from(currentBridge));
        return currentBridge;
    }

    public int move(int index) {
        if (isRightStep(index)) {
            return index + 1;
        }
        if (isLeftStep(index)) {
            return index - 1;
        }
        return index;
    }

    private boolean isRightStep(int index) {
        return index < points.size() && points.get(index).hasBridge();
    }

    private boolean isLeftStep(int index) {
        return index > 0 && points.get(index - 1).hasBridge();
    }

    public Point get(int index) {
        return points.get(index);
    }

    public int size() {
        return points.size();
    }

    public List<Point> getValues() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public Iterator<Point> iterator() {
        return points.iterator();
    }
}
