package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {

    private final Random random;

    public LadderGenerator(Random random) {
        this.random = random;
    }

    public Ladder generate(Height height, Width width) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(generateConnections(width)));
        }

        return new Ladder(height, lines);
    }

    private List<Boolean> generateConnections(Width width) {
        List<Boolean> connections = new ArrayList<>();

        for (int i = 0; i < width.getWidth() - 1; i++) {
            if (i > 0 && connections.get(i - 1)) {
                connections.add(false);
            } else {
                connections.add(random.nextBoolean());
            }
        }

        return connections;
    }
}
