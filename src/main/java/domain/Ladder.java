package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final String ERROR_SIZE = "사다리의 크기는 1 이상이어야합니다.";
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(int width, int height) {
        validateLadder(width, height);
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.generate(width));
        }
        return new Ladder(lines);
    }

    private static void validateLadder(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
