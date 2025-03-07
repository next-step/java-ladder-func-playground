package model;

import java.util.*;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean hasBridgeAt(int index) {
        return points.get(index);
    }

    public void setBridgeAt(int index) {
        points.set(index, true);
    }
}
