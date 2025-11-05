package model.ladder;

import model.ladder.generator.ConnectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_WIDTH = 2;
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines;
    private final int height;

    public Ladder(int width, int height, ConnectionGenerator connectionGenerator) {
        validateLadderSize(width, height);
        this.height = height;
        this.lines = createLines(width, height, connectionGenerator);
    }

    private void validateLadderSize(int width, int height) {
        if (width < MIN_LADDER_WIDTH) {
            throw new IllegalArgumentException(String.format("사다리 폭은 %d 이상이어야 합니다.", MIN_LADDER_WIDTH));
        }
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 %d 이상이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }

    private List<Line> createLines(int width, int height, ConnectionGenerator connectionGenerator) {
        List<Line> lines = new ArrayList<>();
        int pointCount = width - 1;

        for (int i = 0; i < height; i++) {
            lines.add(Line.generateRandomLine(pointCount, connectionGenerator));
        }

        return lines;
    }

    public int getHeight() {
        return height;
    }

    public Line getLine(int row) {
        return lines.get(row);
    }
}
