package domain.ladder;

import domain.BooleanGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int width, BooleanGenerator booleanGenerator) {
        this.lines = generateLines(height, width, booleanGenerator);
    }

    private List<Line> generateLines(int height, int width, BooleanGenerator booleanGenerator) {
        return IntStream.range(0, height)
                .mapToObj((i) -> new Line(width, booleanGenerator))
                .toList();
    }

    public int getLadderEndPoint(int startPoint) {
        int point = startPoint;
        for (Line line : lines) {
            point = line.getMovePoint(point);
        }

        return point;
    }

    public List<Line> getLines() {
        return lines;
    }
}
