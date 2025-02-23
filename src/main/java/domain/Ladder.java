package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int HEIGHT = 4;
    private static final int WIDTH = 4;
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder createLadder() {
        List<Line> lines = new ArrayList<>();
        int pointCount = WIDTH - 1;
        for (int i = 0; i < HEIGHT; i++) {
            lines.add(Line.createRandomLine(pointCount));
        }
        return new Ladder(lines);
    }
}
