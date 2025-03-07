package domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> drawAll() {
        List<String> drawn = new ArrayList<>();
        for (Line line : lines) {
            drawn.add(line.draw());
        }
        return drawn;
    }

    public Position moveAll(Position position) {
        Position result = position;
        for (Line line : lines) {
            result = line.move(result);
        }
        return result;
    }

    public int getColumnCount() {
        if (lines.isEmpty()) {
            return 0;
        }
        return lines.get(0).getBridges().size() + 1;
    }
}
