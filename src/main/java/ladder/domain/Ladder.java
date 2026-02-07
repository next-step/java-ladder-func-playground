package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderWidth width;
    private final LadderHeight height;

    private Ladder(List<Line> lines, LadderWidth width, LadderHeight height) {
        this.lines = lines;
        this.width = width;
        this.height = height;
    }

    public static Ladder of(LadderWidth width, LadderHeight height) {
        List<Line> lines = generateLines(width, height);

        return new Ladder(lines, width, height);
    }

    private static List<Line> generateLines(LadderWidth width, LadderHeight height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(Line.from(width.getPointCount()));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
