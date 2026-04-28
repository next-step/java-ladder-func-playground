package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line generateFirst(LadderWidth width, BooleanGenerator generator) {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;
        for (int i = 0; i < width.getIntervalCount(); i++) {
            previous = addPoint(points, previous, false, generator);
        }
        return new Line(points);
    }

    public static Line generateNext(LadderWidth width, BooleanGenerator generator, Line previousLine) {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;
        for (int i = 0; i < width.getIntervalCount(); i++) {
            boolean above = previousLine.isConnectedAt(i);
            previous = addPoint(points, previous, above, generator);
        }
        return new Line(points);
    }

    private static boolean addPoint(List<Boolean> points, boolean previous, boolean above, BooleanGenerator gen) {
        boolean nextPoint = determineNext(previous, above, gen);
        points.add(nextPoint);
        return nextPoint;
    }

    private static boolean determineNext(boolean previous, boolean above, BooleanGenerator gen) {
        if (previous || above) {
            return false;
        }
        return gen.generate();
    }

    public boolean isConnectedAt(int index) {
        return points.get(index);
    }

    public Position move(Position position) {
        int currentIndex = position.getValue();
        if (canMoveLeft(currentIndex)) {
            return position.moveLeft();
        }
        if (canMoveRight(currentIndex)) {
            return position.moveRight();
        }
        return position;
    }

    private boolean canMoveLeft(int currentIndex) {
        if (currentIndex <= 0) {
            return false;
        }
        return points.get(currentIndex - 1);
    }

    private boolean canMoveRight(int currentIndex) {
        if (currentIndex >= points.size()) {
            return false;
        }
        return points.get(currentIndex);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
