package domain.ladder;

import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = List.copyOf(points);
    }

    public static Line from(final List<Point> points) {
        return new Line(points);
    }

    public boolean hasConnectionAt(final int index) {
        return points.get(index).isConnectRight();
    }

    public Direction directionAt(final int index) {
        if (canMoveRight(index)) {
            return Direction.RIGHT;
        }
        if (canMoveLeft(index)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private boolean canMoveRight(final int index) {
        return index < points.size() - 1 && points.get(index).isConnectRight();
    }

    private boolean canMoveLeft(final int index) {
        return 0 < index && points.get(index - 1).isConnectRight();
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return points;
    }
}
