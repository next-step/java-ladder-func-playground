package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line createRandomLine(int count) {
        List<Boolean> points = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            points.add(generateRandomConnection(points, random));
        }
        return new Line(points);
    }

    private static boolean generateRandomConnection(List<Boolean> previousPoints, Random random) {
        if (hasPreviousConnection(previousPoints)) {
            return false;
        }
        return random.nextBoolean();
    }

    private static boolean hasPreviousConnection(List<Boolean> previousPoints) {
        if (previousPoints.isEmpty()) {
            return false;
        }
        return previousPoints.get(previousPoints.size() - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
