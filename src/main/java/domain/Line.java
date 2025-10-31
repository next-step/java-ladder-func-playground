package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public static Line create(int playerCount, Random random) {
        List<Point> points = new ArrayList<>();
        Connect prev = Connect.DISCONNECTED;

        for (int i = 0; i < playerCount - 1; i++) {
            Connect next = Connect.from(random.nextBoolean());
            next = checkPrev(prev, next);
            points.add(new Point(next));
            prev = next;
        }
        return new Line(points);
    }

    private static Connect checkPrev(Connect prev, Connect next) {
        if (prev.isConnected()) {
            return Connect.DISCONNECTED;
        }
        return next;
    }

    public Connect validateMoveRight(int index) {
        if (index >= points.size()) return Connect.DISCONNECTED;
        return points.get(index).point();
    }

    public Connect validateMoveLeft(int index) {
        if (index == 0) return Connect.DISCONNECTED;
        return points.get(index - 1).point();
    }

    public List<Point> getPoints() {
        return points;
    }
}
