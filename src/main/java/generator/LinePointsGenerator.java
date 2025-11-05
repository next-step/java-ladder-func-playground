package generator;

import domain.LinePoints;
import domain.PointConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinePointsGenerator {
    private final Random random = new Random();

    public LinePoints generateLinePoints(int colCount) {
        List<PointConnection> pointConnections = new ArrayList<>(colCount - 1);
        for (int i = 0; i < colCount - 1; i++) {
            boolean isConnected = shouldConnect(i, pointConnections);
            pointConnections.add(new PointConnection(isConnected));
        }

        return new LinePoints(pointConnections);
    }

    private boolean shouldConnect(int index, List<PointConnection> pointConnections) {
        if (index > 0 && pointConnections.get(index - 1).isConnected()) {
            return false;
        }
        return random.nextBoolean();
    }
}

