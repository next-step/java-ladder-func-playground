package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    private final RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();

    public Ladder createLadder(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createLine(width));
        }
        return new Ladder(lines);
    }

    public Line createLine(int width) {
        List<Boolean> points = new ArrayList<>();
        points.add(createPoints(0, width, false));
        for (int index = 1; index < width; index++) {
            Boolean beforePoint = points.get(index - 1);
            points.add(createPoints(index, width, beforePoint));
        }
        return new Line(points);
    }

    private Boolean createPoints(int index, int width, Boolean beforePoint) {
        if (index == (width - 1) || beforePoint) {
            return false;
        }
        return randomBooleanGenerator.generateRandomBoolean();
    }
}
