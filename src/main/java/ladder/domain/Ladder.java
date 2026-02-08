package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class Ladder {

    private final List<Line> lines;
    private final LadderWidth width;
    private final LadderHeight height;

    private Ladder(List<Line> lines, LadderWidth width, LadderHeight height) {
        this.lines = lines;
        this.width = width;
        this.height = height;
    }

    public static Ladder of(LadderWidth width, LadderHeight height, BooleanSupplier strategy) {
        List<Line> lines = generateLines(width, height, strategy);

        return new Ladder(lines, width, height);
    }

    public int climb(int startIndex) {
        int currentIndex = startIndex;
        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }

    public Map<Integer, Integer> generateResults() {
        Map<Integer, Integer> results = new LinkedHashMap<>();
        for (int i = 0; i < width.getValue(); i++) {
            results.put(i, climb(i));
        }
        return results;
    }

    private static List<Line> generateLines(LadderWidth width, LadderHeight height, BooleanSupplier strategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(Line.from(width.getPointCount(), strategy));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
