package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public List<Point> getPointsFromLines() {
        List<Point> result = new ArrayList<>();
        for (Line line : lines) {
            result.addAll(line.getPointGroups());
        }
        return List.copyOf(result);
    }
}
