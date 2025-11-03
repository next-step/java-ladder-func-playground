package domain;

import java.util.List;

public class Ladder {
    private final List<LinePoints> lines;
    private final int cols;
    private final int rows;

    public Ladder(List<LinePoints> lines, int cols, int rows) {
        validateCols(cols);
        validateRows(rows);
        validateLines(lines, rows);
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

    private void validateCols(int cols) {
        if (cols < 2) throw new IllegalArgumentException("사다리 너비(cols)는 2 이상이어야 합니다.");
    }

    private void validateRows(int rows) {
        if (rows < 1) throw new IllegalArgumentException("사다리 높이(rows)는 1 이상이어야 합니다.");
    }

    private void validateLines(List<LinePoints> lines, int rows) {
        if (lines.size() != rows) throw new IllegalArgumentException("라인 개수와 rows가 일치하지 않습니다.");
    }

}