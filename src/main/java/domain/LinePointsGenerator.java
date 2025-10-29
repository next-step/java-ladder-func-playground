package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinePointsGenerator {
    private final Random random = new Random();

    public LinePoints generateLine(int colCount) {
        List<Boolean> points = new ArrayList<>(colCount - 1);
        for (int i = 0; i < colCount - 1; i++) {
            if (i > 0 && points.get(i - 1)) points.add(false);
            else points.add(random.nextBoolean());
        }
        return new LinePoints(points);
    }
}

