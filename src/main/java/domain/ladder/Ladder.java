package domain.ladder;

import domain.Line;
import domain.Width;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = List.copyOf(lines);
    }

    public static Ladder from(final List<Line> lines) {
        return new Ladder(lines);
    }

    public boolean isFullyConnected(final Width width) {
        return IntStream.range(0, width.value() - 1)
                .allMatch(this::isConnectedBetween);
    }

    private boolean isConnectedBetween(final int index) {
        return lines.stream()
                .anyMatch(line -> line.hasConnectionAt(index));
    }

    public List<Line> getLines() {
        return lines;
    }
}
