package io.suhan.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {
    private static final Random random = new Random();

    public static Ladder createLadder(int width, int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            List<Connection> connections = new ArrayList<>();
            int j = 0;

            while (j < width - 1) {
                boolean value = random.nextBoolean();

                if (value) {
                    connections.add(new Connection(j, j + 1));
                    j += 2;
                } else {
                    j += 1;
                }
            }

            lines.add(new Line(connections));
        }

        return new Ladder(width, height, lines);
    }
}
