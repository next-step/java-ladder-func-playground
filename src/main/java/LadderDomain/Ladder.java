package LadderDomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int width) {
        BooleanValueGenerator generator = new LadderConnectionGenerator();
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, generator));
        }
    }

    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
