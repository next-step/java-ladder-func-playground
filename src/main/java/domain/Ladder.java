package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(Size size) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < size.getHeight(); i++) {
            lines.add(Line.create(size.getWidth()));
        }
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
