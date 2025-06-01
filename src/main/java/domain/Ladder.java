package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.LineGenerator;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder create(final int width, final int height, final LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(width));
        }

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
