package io.suhan.ladder.model;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final int width;
    private final int height;

    public Ladder(int width, int height, List<Line> lines) {
        this.width = width;
        this.height = height;
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
