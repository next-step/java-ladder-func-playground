package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLadderGenerator implements LadderGenerator {
    private final List<Line> lines = new ArrayList<>();
    private static int HEIGHT = 4;

    public RandomLadderGenerator() {
    }

    public List<Line> generateLadder() {
        for (int i = 0; i < HEIGHT; i++) {
            lines.add(new Line());
        }

        return lines;
    }
}
