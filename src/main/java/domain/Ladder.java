package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int width, Random random) {
        this.lines = generateLadder(height, width, random);
    }

    private List<Line> generateLadder(int height, int width, Random random) {
        List<Line> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            result.add(new Line(width, random));
        }
        return result;
    }

    public List<Line> lines() {
        return lines;
    }
}
