package model;

import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = List.copyOf(points);
    }

    public int move(int position) {
        if(canMoveLeft(position)) {
            return position -1;
        }

        if(canMoveRight(position)) {
            return position + 1;
        }
        return position;
    }

    private boolean canMoveLeft(int position) {
        return position > 0 && points.get(position - 1) == Point.HAS_POINT;
    }

    private boolean canMoveRight(int position) {
        return position < points.size() - 1 && points.get(position) == Point.HAS_POINT;

    }

    public List<Point> getPointGroups() {
        return List.copyOf(points);
    }
}
