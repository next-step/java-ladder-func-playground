package domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
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
}
