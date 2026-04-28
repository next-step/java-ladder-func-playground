package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line generate(LadderWidth width, BooleanGenerator generator) {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;
        for (int i = 0; i < width.getIntervalCount(); i++) {
            previous = addPointAndReturnPrevious(points, previous, generator);
        }
        return new Line(points);
    }

    private static boolean addPointAndReturnPrevious(List<Boolean> points, boolean previous, BooleanGenerator generator) {
        boolean nextPoint = generateNext(previous, generator);
        points.add(nextPoint);
        return nextPoint;
    }

    private static boolean generateNext(boolean previous, BooleanGenerator generator) {
        if (previous) {
            return false;
        }
        return generator.generate();
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}