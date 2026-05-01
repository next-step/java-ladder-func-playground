package domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
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
