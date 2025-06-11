package strategy;

import domain.ladder.Line;
import domain.ladder.Point;
import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {

    private final PointGenerator pointGenerator;

    public RandomLineGenerator(final PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    @Override
    public Line generate(final int width) {
        List<Point> points = new ArrayList<>();
        Point current = Point.from(pointGenerator.generate());
        points.add(current);

        for (int i = 1; i < width; i++) {
            current = current.connectNext(pointGenerator.generate());
            points.add(current);
        }

        return Line.from(points);
    }
}
