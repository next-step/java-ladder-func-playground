package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = List.copyOf(points);
    }

    public static Line create(int playerCount, Random random) {
        List<Boolean> points = new ArrayList<>();
        boolean prev = false;

        for (int i = 0; i < playerCount - 1; i++) {
            boolean next = random.nextBoolean();
            next = checkPrev(prev, next);
            points.add(next);
            prev = next;
        }
        return new Line(points);
    }

    private static boolean checkPrev(boolean prev, boolean next) {
        if (prev) {
            next = false;
        }
        return next;
    }

    public boolean validateMoveRight(int index) {
        if (index >= points.size()) return false;
        return points.get(index);
    }

    public boolean validateMoveLeft(int index) {
        if (index == 0) return false;
        return points.get(index - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
