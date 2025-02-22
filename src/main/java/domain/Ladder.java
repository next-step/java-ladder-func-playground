package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int width) {
        this.lines = generateLines(height, width);
    }

    private List<Line> generateLines(int height, int width) {
        return IntStream.range(0, height)
                .mapToObj((i) -> new Line(width))
                .toList();
    }

    public List<Line> getLines() {
        return lines;
    }
}
