package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final LadderSize ladderSize;
    private final List<Line> lines;

    public Ladder(int width, int height) {
        this.ladderSize = new LadderSize(width, height);
        this.lines = drawLines(width, height);
    }

    private List<Line> drawLines(int width, int height) {
        int pointCount = width - 1;
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.createRandomLine(pointCount));
        }
        return lines;
    }

    public LadderSize getLadderSize() {
        return ladderSize;
    }

    public List<Line> getLines() {
        return lines;
    }
}
