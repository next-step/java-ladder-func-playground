package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Size width, Size height) {
        this.lines = generateLines(width, height);
    }

    private List<Line> generateLines(Size width, Size height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getSize(); i++) {
            lines.add(new Line(width));
        }
        return List.copyOf(lines);
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
