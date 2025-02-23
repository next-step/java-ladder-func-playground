package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder createLadder(int width, int height) {
        int pointCount = width - 1;
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.createRandomLine(pointCount));
        }
        return new Ladder(lines);
    }
}
