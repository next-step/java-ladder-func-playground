package model;

import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    public Ladder(Height height, List<Line> lines) {
        this.height = height;
        this.lines = lines;
    }

    public int move(int index) {
        int position = index;

        for (Line line : lines) {
            position = line.move(position);
        }

        return position;
    }

    public List<Line> getLines() {
        return lines;
    }
}
