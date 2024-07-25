package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public static Line of(int width, Random random) {
        Deque<Boolean> points = new ArrayDeque<>();
        points.addLast(false);

        while (points.size() < width) {
            points.addLast(generateNext(points.peekLast(), random));
        }

        points.pollFirst();

        return new Line(new ArrayList<>(points));
    }

    private static boolean generateNext(Boolean previous, Random random) {
        if (Boolean.TRUE.equals(previous)) {
            return false;
        }

        return random.nextBoolean();
    }
}
