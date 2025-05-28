package domain;

import config.GameConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    private final Random random = new Random();

    public Ladder generate(GameConfig config) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < config.getHeight(); i++) {
            lines.add(generateLine(config.getWidth()));
        }
        return new Ladder(lines);
    }

    private Line generateLine(int width) {
        List<Connection> connections = new ArrayList<>();
        boolean prev = false;
        for (int i = 0; i < width - 1; i++) {
            boolean connect = !prev && random.nextBoolean();
            connections.add(new Connection(connect));
            prev = connect;
        }
        return new Line(connections);
    }

}
