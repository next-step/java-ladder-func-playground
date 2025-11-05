package generator;

import domain.LinePoints;
import domain.PointConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinePointsGenerator {
    private final Random random = new Random();

    public LinePoints generateLinePoints(int colCount) {
        List<Boolean> booleanPoints = new ArrayList<>(colCount - 1);
        for (int i = 0; i < colCount - 1; i++) {
            if (i > 0 && booleanPoints.get(i - 1)) {
                booleanPoints.add(false);
            } else {
                booleanPoints.add(random.nextBoolean());
            }
        }

        List<PointConnection> pointConnections = new ArrayList<>(booleanPoints.size());
        for (Boolean b : booleanPoints) {
            pointConnections.add(new PointConnection(Boolean.TRUE.equals(b)));
        }

        return new LinePoints(pointConnections);
    }
}

