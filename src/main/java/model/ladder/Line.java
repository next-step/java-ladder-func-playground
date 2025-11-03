package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line generateRandomLine(int numberOfPoints, Random random) {
        List<Point> generatedPoints = new ArrayList<>();
        ConnectionStatus previousStatus = ConnectionStatus.DISCONNECTED;

        for (int i = 0; i < numberOfPoints; i++) {
            ConnectionStatus nextStatus = decideNextConnection(random, previousStatus);
            generatedPoints.add(new Point(nextStatus));
            previousStatus = nextStatus;
        }
        return new Line(generatedPoints);
    }

    private static ConnectionStatus decideNextConnection(Random random, ConnectionStatus previousStatus) {
        if (previousStatus.isConnected()) {
            return ConnectionStatus.DISCONNECTED;
        }
        return ConnectionStatus.from(random.nextBoolean());
    }

    public boolean isConnectedAt(int column) {
        return points.get(column).isConnected();
    }

    public int getPointCount() {
        return points.size();
    }
}
