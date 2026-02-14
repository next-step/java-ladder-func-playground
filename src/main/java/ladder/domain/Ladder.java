package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Lines lines;
    private final int width;

    private Ladder(Lines lines, int width) {
        this.lines = lines;
        this.width = width;
    }

    public static Ladder of(Participants participants, LadderHeight height, BooleanSupplier strategy) {
        int participantCount = participants.size();
        Lines lines = Lines.of(participantCount, height, strategy);
        return new Ladder(lines, participantCount);
    }

    public int climb(int startIndex) {
        return lines.move(startIndex);
    }

    public Map<Integer, Integer> generateResults() {
        return IntStream.range(0, width)
            .boxed()
            .collect(Collectors.toMap(
                index -> index,
                this::climb,
                (oldValue, newValue) -> newValue,
                LinkedHashMap::new
            ));
    }

    private static List<Line> generateLines(int participantCount, LadderHeight height, BooleanSupplier strategy) {
        List<Line> lines = new ArrayList<>();
        int pointCount = participantCount - 1;
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(Line.from(pointCount, strategy));
        }
        return lines;
    }

    public Lines getLines() {
        return lines;
    }
}
