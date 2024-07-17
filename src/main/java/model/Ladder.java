package model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private final Integer width;
    private final Integer height;

    public Ladder(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        this.lines = new ArrayList<>(height);
        initLadderLines();
    }

    public Integer getResultIndexByPlayerIndex(Integer playerIndex) {
        Integer currentColumn = playerIndex;
        for (Line line : lines) {
            currentColumn = moveColumn(currentColumn, line);
        }
        return currentColumn;
    }

    private Integer moveColumn(Integer currentColumn, Line line) {
        if (canMoveLeft(currentColumn, line)) {
            return --currentColumn;
        }
        if (canMoveRight(currentColumn, line)) {
            return ++currentColumn;
        }
        return currentColumn;
    }

    private boolean canMoveLeft(Integer currentColumn, Line line) {
        if (currentColumn == 0) {
            return false;
        }
        return line.getPoints().get(currentColumn - 1);
    }

    private boolean canMoveRight(Integer currentColumn, Line line) {
        if (currentColumn == width - 1) {
            return false;
        }
        return line.getPoints().get(currentColumn);
    }

    private void initLadderLines() {
        for (int i = 0; i < height; ++i) {
            lines.add(new Line(width));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(line -> {
            stringBuilder.append(line.toString());
            stringBuilder.append("\n");
        });
        return stringBuilder.toString();
    }
}
