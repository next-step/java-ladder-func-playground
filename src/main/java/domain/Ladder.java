package domain;

import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리는 최소 한 줄 이상이어야 합니다.");
        }

        this.lines = List.copyOf(lines);
    }

    public int traverse(int startPosition) {
        int position = startPosition;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return lines;
    }
}
