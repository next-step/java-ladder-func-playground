package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int width;
    private final List<Line> lines;

    public Ladder(int width, int height) {
        this.width = width;
        this.lines = drawLines(width, height);
    }

    private List<Line> drawLines(int width, int height) {
        int pointCount = width - 1;
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.createRandomLine(pointCount));
        }
        return lines;
    }

    public int getWidth() {
        return width;
    }

    public List<Line> getLines() {
        return lines;
    }
}
