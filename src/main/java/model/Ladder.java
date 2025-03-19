package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public static Ladder createLadder(int playerCount, int maxHeight, PointGenerator pointGenerator) {
        List<Line> lines = Line.createLines(playerCount, maxHeight, pointGenerator);
        return new Ladder(lines);
    }

    public int move(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<Point> getPointsFromLines() {
        List<Point> result = new ArrayList<>();
        for (Line line : lines) {
            result.addAll(line.getPointGroups());
        }
        return List.copyOf(result);
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
