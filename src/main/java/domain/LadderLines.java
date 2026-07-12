package domain;

import java.util.List;
import java.util.stream.IntStream;

public class LadderLines {

    private final List<LadderLine> lines;

    public LadderLines(List<LadderLine> lines) {
        this.lines = List.copyOf(lines);
    }

    public static LadderLines of(int width, LadderHeight height, RandomStrategy strategy) {
        return new LadderLines(
                IntStream.range(0, height.value())
                        .mapToObj(i -> new LadderLine(width, strategy))
                        .toList()
        );
    }

    public int getFinalPosition(int startPosition) {
        int currentPosition = startPosition;

        for (LadderLine line : lines) {
            currentPosition = line.move(currentPosition);
        }

        return currentPosition;
    }

    public List<LadderLine> getLines() {
        return List.copyOf(lines);
    }
}
