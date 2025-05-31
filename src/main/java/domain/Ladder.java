package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointGenerator;

public class Ladder {

    public static final int MIN_LADDER_SIZE = 2;

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder create(final int width, final int height, final PointGenerator generator) {
        validateLadderSize(width, height);

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.create(width, generator));
        }

        return new Ladder(lines);
    }

    private static void validateLadderSize(final int width, final int height) {
        if (width < MIN_LADDER_SIZE || height < MIN_LADDER_SIZE) {
            throw new IllegalArgumentException("사다리의 넓이와 높이는 최소 %s어야 합니다.".formatted(MIN_LADDER_SIZE));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
