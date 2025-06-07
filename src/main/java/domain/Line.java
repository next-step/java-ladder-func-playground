package domain;

import java.util.List;

public class Line {

    final List<Point> points;

    private Line(final List<Point> points) {
        this.points = List.copyOf(points);
    }

    public static Line from(final List<Point> points) {
        return new Line(points);
    }

    public boolean hasConnectionAt(final int index) {
        return points.get(index).right();
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
        return index < points.size() - 1 && points.get(index).right();
    }

    private boolean canMoveLeft(final int index) {
        return 0 < index && points.get(index - 1).right();
    }

    public List<Point> getPoints() {
        return points;
    }
}
