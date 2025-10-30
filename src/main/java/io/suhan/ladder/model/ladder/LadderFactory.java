package io.suhan.ladder.model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {
    private static final Random DEFAULT_RANDOM = new Random();

    public static Ladder createLadder(int width, int height) {
        return createLadder(width, height, DEFAULT_RANDOM);
    }

    public static Ladder createLadder(int width, int height, Random random) {
        List<Line> lines = createLines(width, height, random);

        return new Ladder(lines);
    }

    private static List<Line> createLines(int width, int height, Random random) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(createLine(width, random));
        }

        return lines;
    }

    private static Line createLine(int width, Random random) {
        List<Connection> connections = createConnections(width, random);

        return new Line(connections);
    }

    private static List<Connection> createConnections(int width, Random random) {
        List<Connection> connections = new ArrayList<>();

        // TODO: depth 줄이기
        for (int i = 0; i < width - 1; i++) {
            if (shouldConnect(random)) {
                connections.add(new Connection(i, i + 1));
                i += 1; // skip the right next line
            }
        }

        return connections;
    }

    private static boolean shouldConnect(Random random) {
        return random.nextBoolean();
    }
}
