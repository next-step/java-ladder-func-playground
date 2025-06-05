package domain;

import java.util.List;

public class Line {

    final List<Point> points;

    private Line(final List<Point> points) {
        this.points = List.copyOf(points);
    }

    public static Line from(final List<Point> points) {
        return new Line(points);
    }

    public boolean hasConnectionAt(final int index) {
        return points.get(index).right();
    }

    public List<Point> getPoints() {
        return points;
    }
}
