package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.create(width));
        }
        return new Ladder(lines);
    }

    public void draw() {
        for (Line line : lines) {
            line.draw();
        }
    }

    public List<Integer> result() {
        int width = lines.get(0).getPoints().size() + 1;
        List<Integer> results = new ArrayList<>();

        for (int start = 0; start < width; start++) {
            results.add(getEndPoint(start));
        }

        return results;
    }

    private int getEndPoint(int start) {
        int position = start;

        for (Line line : lines) {
            position = move(position, line.getPoints());
        }

        return position;
    }

    private int move(int position, List<Boolean> points) {
        if (canMoveLeft(position, points)) {
            return position - 1;
        }

        if (canMoveRight(position, points)) {
            return position + 1;
        }

        return position;
    }

    private boolean canMoveLeft(int position, List<Boolean> points) {
        return position > 0 && points.get(position - 1);
    }

    private boolean canMoveRight(int position, List<Boolean> points) {
        return position < points.size() && points.get(position);
    }
}
