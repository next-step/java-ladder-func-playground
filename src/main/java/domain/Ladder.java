package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(int height, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.generate(width));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
