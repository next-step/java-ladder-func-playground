package domain.ladder;

import domain.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(int width, BooleanGenerator booleanGenerator) {
        this.points = generatePoints(width, booleanGenerator);
    }

    private List<Boolean> generatePoints(int width, BooleanGenerator booleanGenerator) {
        List<Boolean> tempPoints = new ArrayList<>();
        for (int index = 0; index < width - 1; index++) {
            tempPoints.add(generatePoint(index, tempPoints, booleanGenerator));
        }

        return tempPoints;
    }

    private Boolean generatePoint(int index, List<Boolean> tempPoints, BooleanGenerator booleanGenerator) {
        if (index > 0 && tempPoints.get(index - 1)) {
            return false;
        }
        return booleanGenerator.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getMovePoint(int x) {
        if (canMoveRight(x)) {
            return x + 1;
        }
        if (canMoveLeft(x)) {
            return x - 1;
        }
        return x;
    }

    private boolean canMoveRight(int x) {
        return x < points.size() && points.get(x);
    }

    private boolean canMoveLeft(int x) {
        return x > 0 && points.get(x - 1);
    }
}
