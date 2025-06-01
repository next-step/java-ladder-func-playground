package strategy;

import domain.Line;
import domain.Point;
import java.util.ArrayList;
import java.util.List;

public class FixedLineGenerator implements LineGenerator {

    private final List<boolean[]> fixedValuesList;
    private int index = 0;

    public FixedLineGenerator(final List<boolean[]> fixedValuesList) {
        this.fixedValuesList = fixedValuesList;
    }

    @Override
    public Line generate(int width) {
        boolean[] values = fixedValuesList.get(index++);
        Point first = Point.first(values[0]);
        List<Point> points = new ArrayList<>();
        points.add(first);

        for (int i = 1; i < width; i++) {
            first = first.connectNext(values[i]);
            points.add(first);
        }

        return Line.of(points);
    }
}
