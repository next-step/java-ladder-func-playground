package generator;

import domain.ConnectionStatus;
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
            ConnectionStatus status = determineConnectionStatus(i, pointConnections);
            pointConnections.add(new PointConnection(status));
        }

        return new LinePoints(pointConnections);
    }

    private ConnectionStatus determineConnectionStatus(int index, List<PointConnection> pointConnections) {
        if (index > 0 && pointConnections.get(index - 1).isConnected()) {
            return ConnectionStatus.DISCONNECTED;
        }
        return random.nextBoolean() ? ConnectionStatus.CONNECTED : ConnectionStatus.DISCONNECTED;
    }
}
