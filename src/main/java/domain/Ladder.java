package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;
    private final int count;

    public Ladder(int height, int width) {
        this.lines = generateLines(height, width);
        this.count = width;
    }

    private List<Line> generateLines(int height, int width) {
        return IntStream.range(0, height)
                .mapToObj((i) -> new Line(width))
                .toList();
    }

    public Map<Integer, Integer> getLadderAllResult() {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (int i = 0; i < count; i++) {
            int ladderResult = getLadderResult(i);
            result.put(ladderResult, i);
        }

        return result;
    }

    public int getLadderResult(int startPoint) {
        int p = startPoint;
        for (Line line : lines) {
            p = line.getMovePoint(p);
        }

        return p;
    }

    public List<Line> getLines() {
        return lines;
    }
}
