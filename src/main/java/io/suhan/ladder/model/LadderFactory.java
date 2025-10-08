package io.suhan.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {
    private static final Random random = new Random();

    public static Ladder createLadder(int width, int height) {
        List<Line> lines = createLines(width, height);

        return new Ladder(width, height, lines);
    }

    private static List<Line> createLines(int width, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(createLine(width));
        }

        return lines;
    }

    private static Line createLine(int width) {
        List<Connection> connections = createConnections(width);

        return new Line(connections);
    }

    private static List<Connection> createConnections(int width) {
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < width - 1; i++) {
            if (shouldConnect()) {
                connections.add(new Connection(i, i + 1));
                i += 1; // skip the right next line
            }
        }

        return connections;
    }

    private static boolean shouldConnect() {
        return random.nextBoolean();
    }
}
