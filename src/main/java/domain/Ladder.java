package domain;

import java.util.List;

public class Ladder {
    private final List<LinePoints> lines;

    public Ladder(List<LinePoints> lines) {
        this.lines = lines;
    }

    public List<LinePoints> getLines() {
        return lines;
    }
}