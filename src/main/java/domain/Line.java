package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Connect> points;

    private Line(List<Connect> points) {
        this.points = List.copyOf(points);
    }

    static Line of(List<Connect> points) {
        return new Line(points);
    }

    public static Line create(int playerCount, Random random) {
        List<Connect> points = new ArrayList<>();
        Connect prev = Connect.DISCONNECTED;

        for (int i = 0; i < playerCount - 1; i++) {
            Connect next = Connect.from(random.nextBoolean());
            next = checkPrev(prev, next);
            points.add(next);
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

    private Connect rightOf(int index) {
        if (index >= points.size()) return Connect.DISCONNECTED;
        return points.get(index);
    }

    private Connect leftOf(int index) {
        if (index <= 0) return Connect.DISCONNECTED;
        return points.get(index - 1);
    }

    public int moveOf(int index) {
        Connect right = rightOf(index);
        if (right.isConnected()) return right.moveRight(index);

        Connect left = leftOf(index);
        if (left.isConnected()) return left.moveLeft(index);

        return index;
    }

    public List<Connect> getPoints() {
        return points;
    }
}
