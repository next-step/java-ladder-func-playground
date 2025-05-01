package LadderDomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final List<Line> lines;

    public Ladder(int height, int width) {
        lines = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, random));
        }
    }

    public int move(int index) {
        int position = index;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
