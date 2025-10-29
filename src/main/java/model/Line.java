package model;

import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = Objects.requireNonNull(points);
    }

    public List<Point> points() {
        return points;
    }
}
