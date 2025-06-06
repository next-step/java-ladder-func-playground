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
}
