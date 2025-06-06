package domain.ladder;

import domain.Direction;
import domain.Line;
import domain.Width;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
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

    public int move(final int startIndex) {
        int position = startIndex;
        for (Line line : lines) {
            Direction direction = line.directionAt(position);
            position = direction.moveFrom(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
