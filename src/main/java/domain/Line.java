package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointGenerator;

public class Line {

    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static Line create(final int width, final PointGenerator generator) {
        return new Line(generatePoints(width, generator));
    }

    private static List<Point> generatePoints(final int width, final PointGenerator generator) {
        List<Point> points = new ArrayList<>();
        Point first = Point.first(generator.generate());
        points.add(first);

        for (int i = 1; i < width; i++) {
            first = first.connectNext(generator.generate());
            points.add(first);
        }

        return points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
