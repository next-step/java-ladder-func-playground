package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int ladderSize, int lineSize) {
        this.lines = generateLines(ladderSize, lineSize);
    }

    private List<Line> generateLines(int ladderSize, int lineSize) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderSize; i++) {
            lines.add(new Line(lineSize));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
