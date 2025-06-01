package domain;

import config.GameConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public static Ladder from(GameConfig config) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < config.getHeight(); i++) {
            lines.add(generateLine(config.getWidth()));
        }
        return new Ladder(lines);
    }

    private static Line generateLine(int width) {
        Random random = new Random();
        List<Connection> connections = new ArrayList<>();
        boolean prev = false;
        for (int i = 0; i < width - 1; i++) {
            boolean connect = !prev && random.nextBoolean();
            connections.add(new Connection(connect));
            prev = connect;
        }
        return new Line(connections);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int move(int startIndex) {
        int position = startIndex;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public int getWidth() {
        return lines.get(0).getConnections().size() + 1;
    }
}
