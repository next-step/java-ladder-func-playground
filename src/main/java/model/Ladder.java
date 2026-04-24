package model;

import util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();
    int width;
    int height;

    public Ladder(int height, int width) {
        this.width = width;
        this.height = height;
        makeLadder();
    }

    private void makeLadder() {
        for (int i = 0; i < height; i++) {
            Line line = new Line(width, LineGenerator.makeLine(width));
            ladder.add(line);
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

