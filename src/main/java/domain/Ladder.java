package domain;

import java.util.List;

public class Ladder {
    private final List<LinePoints> lines;
    private final int cols;
    private final int rows;

    public Ladder(List<LinePoints> lines, int cols, int rows) {
        this.lines = lines;
        this.cols = cols;
        this.rows = rows;
    }

    public List<LinePoints> getLines() {
        return lines;
    }

    public int getCols() {
        return cols;
    }
    public int getRows() {
        return rows;
    }
}