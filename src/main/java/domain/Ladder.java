package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Size ladderSize;
    private final List<Line> lines;

    public Ladder(int ladderSize, int lineSize) {
        this.ladderSize = new Size(ladderSize);
        this.lines = generateLines(lineSize);
    }

    public List<Line> generateLines(int lineSize) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderSize.getSize(); i++) {
            lines.add(new Line(lineSize));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
