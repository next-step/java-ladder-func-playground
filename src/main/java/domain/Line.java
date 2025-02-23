package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points;
    private final Random random = new Random();

    public Line(int width) {
        this.points = generatePoints(width);
    }

    private List<Boolean> generatePoints(int width) {
        List<Boolean> tempPoints = new ArrayList<>();
        for (int index = 0; index < width - 1; index++) {
            tempPoints.add(generatePoint(index, tempPoints));
        }

        return tempPoints;
    }

    private Boolean generatePoint(int index, List<Boolean> tempPoints) {
        if (index > 0 && tempPoints.get(index - 1)) {
            return false;
        }
        return random.nextBoolean();
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
