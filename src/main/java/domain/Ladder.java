package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Size ladderSize, Size lineSize) {
        this.lines = generateLines(ladderSize, lineSize);
    }

    private List<Line> generateLines(Size ladderSize, Size lineSize) {
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
