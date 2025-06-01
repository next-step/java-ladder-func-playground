package domain;

import java.util.Collections;
import java.util.List;

public class Line {

    final List<Point> points;

    private Line(final List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static Line of(final List<Point> points) {
        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}
