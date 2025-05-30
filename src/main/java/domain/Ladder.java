package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointGenerator;

public class Ladder {
    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder create(final int width, final int height, final PointGenerator generator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.create(width, generator));
        }

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
