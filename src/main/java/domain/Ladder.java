package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder generate(LadderWidth width, LadderHeight height, BooleanGenerator generator) {
        Ladder ladder = createLadder(width, height, generator);
        while (ladder.hasEmptyInterval(width)) {
            ladder = createLadder(width, height, generator);
        }
        return ladder;
    }

    private static Ladder createLadder(LadderWidth width, LadderHeight height, BooleanGenerator generator) {
        List<Line> lines = new ArrayList<>();
        Line currentLine = Line.generateFirst(width, generator);
        lines.add(currentLine);
        return new Ladder(addRemainingLines(lines, width, height, generator, currentLine));
    }

    private static List<Line> addRemainingLines(List<Line> lines, LadderWidth width, LadderHeight height, BooleanGenerator generator, Line firstLine) {
        Line currentLine = firstLine;
        for (int i = 1; i < height.getValue(); i++) {
            currentLine = Line.generateNext(width, generator, currentLine);
            lines.add(currentLine);
        }
        return lines;
    }

    private boolean hasEmptyInterval(LadderWidth width) {
        return IntStream.range(0, width.getIntervalCount())
                .anyMatch(this::isEmptyInterval);
    }

    private boolean isEmptyInterval(int index) {
        return lines.stream().noneMatch(line -> line.isConnectedAt(index));
    }

    public LadderResult play(LadderWidth width) {
        Map<Position, Position> results = new LinkedHashMap<>();
        for (int i = 0; i < width.getValue(); i++) {
            Position startPosition = new Position(i);
            results.put(startPosition, playOne(startPosition));
        }
        return new LadderResult(results);
    }

    private Position playOne(Position startPosition) {
        Position current = startPosition;
        for (Line line : lines) {
            current = line.move(current);
        }
        return current;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
