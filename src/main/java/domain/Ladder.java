package domain;

import java.util.Collections;
import java.util.List;

public record Ladder(List<LinePoints> lines, int cols, int rows) {
    public Ladder {
        validateCols(cols);
        validateRows(rows);
        validateLines(lines, rows);
        lines = Collections.unmodifiableList(lines);
    }

    public List<LinePoints> getLines() {
        return lines;
    }

    public int getCols() {
        return cols;
    }

    private void validateCols(int cols) {
        if (cols < 2){
            throw new IllegalArgumentException("사다리 너비(cols)는 2 이상이어야 합니다.");
        }
    }

    private void validateRows(int rows) {
        if (rows < 1){
            throw new IllegalArgumentException("사다리 높이(rows)는 1 이상이어야 합니다.");
        }
    }

    private void validateLines(List<LinePoints> lines, int rows) {
        if (lines.size() != rows){
            throw new IllegalArgumentException("라인 개수와 rows가 일치하지 않습니다.");
        }
    }
}