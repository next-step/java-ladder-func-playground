package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final int MINIMUM_WIDTH = 2;
    private static final int MINIMUM_HEIGHT = 1;

    private final List<Line> lines;

    public Ladder(int width, int height) {
        validateSize(width, height);

        this.lines = createLines(width, height);
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getEndPoint(int startPoint) {
        int point = startPoint;

        for (Line line : lines) {
            point = line.getNextPoint(point);
        }

        return point;
    }

    private List<Line> createLines(int width, int height) {
        int linksSize = width - 1;
        DetachedRandomLinksGenerator linksGenerator = new DetachedRandomLinksGenerator(linksSize);

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = new Line(linksGenerator);
            lines.add(line);
        }

        return Collections.unmodifiableList(lines);
    }

    private void validateSize(int width, int height) {
        if (width < MINIMUM_WIDTH) {
            throw new IllegalArgumentException("사다리의 너비는 " + MINIMUM_WIDTH + "보다 짧을 수 없습니다. 전달된 값: " + width);
        }
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 " + MINIMUM_HEIGHT + "보다 짧을 수 없습니다. 전달된 값: " + height);
        }
    }

}
