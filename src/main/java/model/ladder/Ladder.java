package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int MIN_LADDER_WIDTH = 2;
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Line> lines;
    private final int height;

    public Ladder(int width, int height) {
        validateLadderSize(width, height);
        this.height = height;
        this.lines = createLines(width, height);
    }

    //테스트용 생성자
    public Ladder(List<Line> lines) {
        validateLadderLines(lines);
        this.lines = lines;
        this.height = lines.size();
    }

    private void validateLadderSize(int width, int height) {
        if (width < MIN_LADDER_WIDTH) {
            throw new IllegalArgumentException(String.format("사다리 폭은 %d 이상이어야 합니다.", MIN_LADDER_WIDTH));
        }
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 %d 이상이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }

    private void validateLadderLines(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리 라인은 비어있을 수 없습니다.");
        }
    }

    private List<Line> createLines(int width, int height) {
        List<Line> lines = new ArrayList<>();
        int numberOfPoints = width - 1;
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            lines.add(Line.generateRandomLine(numberOfPoints, random));
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
