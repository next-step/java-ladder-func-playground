package testComponents;

import model.Ladder;
import model.LadderBuilder;
import model.Line;
import model.LineBuilder;
import model.Step;

import java.util.ArrayList;
import java.util.List;

public class TestLadderBuilder {

    public static Step step(boolean isBlank) {
        return new Step(isBlank);
    }

    public static Line line(List<Step> steps) {
        return new Line(steps);
    }

    public static LadderBuilder ladderBuilder(LineBuilder lineBuilder) {
        return new LadderBuilder(lineBuilder);
    }

    public static Ladder ladderOfSameLines(int height, Line line) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(line);
        }
        return new Ladder(lines);
    }
}