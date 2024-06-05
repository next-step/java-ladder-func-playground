package model;

import java.util.ArrayList;
import java.util.List;

public class RowLines {
    private final List<Lines> rowLines;
    private static final int INITIAL_NUMBER = 0;

    private RowLines(List<Lines> rowLines) {
        this.rowLines = rowLines;
    }

    public static RowLines of(int height, int width) {
        List<Lines> rowLines = new ArrayList<>();
        for (int i = INITIAL_NUMBER; i < height; i++) {
            rowLines.add(Lines.from(width));
        }
        return new RowLines(rowLines);
    }

    public List<Lines> getRowLines() {
        return rowLines;
    }
}
