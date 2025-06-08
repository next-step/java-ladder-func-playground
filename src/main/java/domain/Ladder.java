package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder() {
        this.lines = new ArrayList<>();
    }

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> getLines() {
        return lines;
    }
}
