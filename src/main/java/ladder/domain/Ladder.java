package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class Ladder {

    private final List<Line> lines;
    private final int width;

    private Ladder(List<Line> lines, int width) {
        this.lines = lines;
        this.width = width;
    }

    public static Ladder of(Participants participants, LadderHeight height, BooleanSupplier strategy) {
        int participantCount = participants.size();
        List<Line> lines = generateLines(participantCount, height, strategy);

        return new Ladder(lines, participantCount);
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
        for (int i = 0; i < width; i++) {
            results.put(i, climb(i));
        }
        return results;
    }

    private static List<Line> generateLines(int participantCount, LadderHeight height, BooleanSupplier strategy) {
        List<Line> lines = new ArrayList<>();
        int pointCount = participantCount - 1;
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(Line.from(pointCount, strategy));
        }
        return lines;
    }

    public List<Line> getLines() {
        return lines;
    }
}
