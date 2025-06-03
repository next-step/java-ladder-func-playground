package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    public static final int SIZE_LIMIT = 0;
    public static final String ERROR_SIZE = "사다리의 크기는 1 이상이어야합니다.";
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(int width, int height) {
        validate(width, height);
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.generate(width));
        }
        return new Ladder(lines);
    }

    private static void validate(int width, int height) {
        if (width <= SIZE_LIMIT || height <= SIZE_LIMIT) {
            throw new IllegalArgumentException(ERROR_SIZE);
        }
    }

    public int move(int startIndex) {
        int position = startIndex;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<List<Boolean>> getLinePoints() {
        return lines.stream()
                .map(Line::getPoints)
                .collect(Collectors.toList());
    }
}
