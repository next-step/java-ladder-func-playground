package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final Lines lines;

    public Ladder(List<Line> lines) {
        this.lines = new Lines(lines);
    }

    public static Ladder of(int height, int width) {
        LineGenerator lineGenerator = new LineGenerator();
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(lineGenerator.createRandomBoolean(width)));
        }

        return new Ladder(lines);
    }

    public void print() {
        for (Line line : lines.getLines()) {
            line.print();
        }

    }
}