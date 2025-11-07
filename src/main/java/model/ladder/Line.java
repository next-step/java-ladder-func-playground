package model.ladder;

import model.ladder.generator.ConnectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line generateRandomLine(int pointCount, ConnectionGenerator connectionGenerator) {
        List<Point> generatedPoints = new ArrayList<>();
        ConnectionStatus previousStatus = ConnectionStatus.DISCONNECTED;

        for (int i = 0; i < pointCount; i++) {
            ConnectionStatus nextStatus = decideNextConnection(connectionGenerator, previousStatus);
            generatedPoints.add(new Point(nextStatus));
            previousStatus = nextStatus;
        }
        return new Line(generatedPoints);
    }

    private static ConnectionStatus decideNextConnection(ConnectionGenerator connectionGenerator, ConnectionStatus previousStatus) {
        if (previousStatus.isConnected()) {
            return ConnectionStatus.DISCONNECTED;
        }
        return ConnectionStatus.from(connectionGenerator.generate());
    }

    public boolean isConnectedAt(int column) {
        return points.get(column).isConnected();
    }

    public int getPointCount() {
        return points.size();
    }
}
