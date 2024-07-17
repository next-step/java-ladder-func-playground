import java.util.ArrayList;
import java.util.List;

import domain.Ladder;
import domain.Line;
import domain.RandomBooleanGenerator;

public class LadderGame {

    private final RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();

    public Ladder createLadder() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lines.add(createLine());
        }
        return new Ladder(lines);
    }

    public Line createLine() {
        List<Boolean> points = new ArrayList<>();
        points.add(createPoints(0, false));
        for (int i = 1; i < 4; i++) {
            Boolean beforePoint = points.get(i - 1);
            points.add(createPoints(i, beforePoint));
        }
        return new Line(points);
    }

    private Boolean createPoints(int index, Boolean beforePoint) {
        if (index == 3 || beforePoint) {
            return false;
        }
        return randomBooleanGenerator.generateRandomBoolean();
    }

}
