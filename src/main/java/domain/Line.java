package domain;

import java.util.List;

public class Line {
    private final List<Connection> points;

    public Line(List<Connection> points) {
        this.points = points;
    }

    public List<Connection> getConnections() {
        return points;
    }
}
