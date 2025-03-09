package model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final PointGenerator generator;

    public LadderGame(Size width, Size height, PointGenerator generator) {
        this.generator = generator;
        this.ladder = new Ladder(generateLines(width, height));
    }

    private List<Line> generateLines(Size width, Size height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getSize(); i++) {
            List<Point> points = generator.createLinePoints(width);
            lines.add(new Line(points));
        }
        return List.copyOf(lines);
    }

    public List<Point> getLadderPoints() {
        return ladder.getPointsFromLines();
    }
}
