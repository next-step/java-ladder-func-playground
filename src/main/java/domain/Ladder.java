package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(LadderHeight height, LadderWidth width) {
        this.lines = new Lines(createLines(height, width));
    }

    private List<Line> createLines(LadderHeight height, LadderWidth width) {
        List<Line> list = new ArrayList<>();
        Line previousLine = null;
        for (int i = 0; i < height.getValue(); i++) {
            Line current = new Line(width, previousLine);
            list.add(current);
            previousLine = current;
        }
        return list;
    }

    public List<String> getLadderBody() {
        return lines.drawAll();
    }

    public LadderResult play() {
        int columnCount = lines.getColumnCount();
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < columnCount; i++) {
            positions.add(lines.moveAll(new Position(i)));
        }
        return new LadderResult(positions);
    }
}
