package model;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = Objects.requireNonNull(lines);
    }

    public List<Line> lines() {
        return lines;
    }
}

