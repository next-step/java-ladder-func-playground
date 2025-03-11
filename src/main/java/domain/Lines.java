package domain;

import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public List<Line> getLines() {
        return lines;
    }
}
