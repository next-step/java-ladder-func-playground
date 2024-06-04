package model;

import java.util.ArrayList;
import java.util.List;

public class RowLines {
<<<<<<< HEAD
    private static final int INITIAL_NUMBER = 0;

    private final List<Lines> rowLines;
    private final Height height;
=======
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
>>>>>>> 0c46fef (Feat:)

    public List<Lines> getRowLines() {
        return rowLines;
    }
<<<<<<< HEAD

    public Height getHeight() {
        return height;
    }

    public static RowLines of(int heightValue, int width) {
        Height height = Height.from(heightValue);
        List<Lines> rowLines = new ArrayList<>();
        setLadder(height.getHeight(), width, rowLines);
        return new RowLines(rowLines, height);
    }

    private RowLines(List<Lines> rowLines, Height height) {
        this.rowLines = rowLines;
        this.height = height;
    }

    private static void setLadder(final int height, final int width, final List<Lines> rowLines) {
        for (int i = INITIAL_NUMBER; i < height; i++) {
            rowLines.add(Lines.from(width));
        }
    }
=======
>>>>>>> 0c46fef (Feat:)
}
