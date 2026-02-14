package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Lines lines;
    private final int width;

    private Ladder(Lines lines, int width) {
        this.lines = lines;
        this.width = width;
    }

    public static Ladder of(Participants participants, Lines lines) {
        return new Ladder(lines, participants.size());
    }

    int climb(int startIndex) {
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

    public Lines getLines() {
        return lines;
    }
}
