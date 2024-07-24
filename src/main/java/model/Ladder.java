package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder of(int width, int height, Random random) {
        List<Line> lines = generateLines(width, height, random);

        while (!validate(width, lines)) {
            lines = generateLines(width, height, random);
        }

        return new Ladder(lines);
    }

    private static List<Line> generateLines(int width, int height, Random random) {
        List<Line> lines = new ArrayList<>();

        for (int i = 1; i < height; i++) {
            lines.add(Line.of(width, random));
        }

        return lines;
    }

    private static boolean validate(int width, List<Line> lines) {
        boolean valid = true;
        for (int i = 0; i < width; i++) {
            valid &= validateConnection(lines, i);
        }

        return valid;
    }

    private static boolean validateConnection(List<Line> lines, int index) {
        int points = 0;
        for (Line line : lines) {
            points += Boolean.compare(line.getPoints().get(index), false);
        }

        return 0 < points;
    }
}
