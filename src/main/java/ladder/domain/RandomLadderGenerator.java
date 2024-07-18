package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLadderGenerator implements LadderGenerator {

    private final List<Line> lines = new ArrayList<>();
    private final int width;
    private final int height;

    public RandomLadderGenerator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public List<Line> generateLadder() {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }

        return lines;
    }
}
