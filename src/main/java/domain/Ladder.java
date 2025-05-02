package domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(BooleanGenerator booleanGenerator, LadderHeight ladderHeight, Players players) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < ladderHeight.height(); i++) {
            lines.add(Line.create(booleanGenerator, players.size()));
        }
        return new Ladder(lines);
    }

    public Map<Integer, Integer> mapStartToEndPositions(int playerSize) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (int position = 0; position < playerSize; position++) {
            result.put(position, traverseLinesFrom(position));
        }
        return result;
    }

    private int traverseLinesFrom( int position) {
        for (Line line : lines) {
            position = line.Move(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return lines;
    }
}
