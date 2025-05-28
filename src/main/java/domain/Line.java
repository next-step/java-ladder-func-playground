package domain;

import java.util.List;

public class Line {
    private final List<Connection> connections;

    public Line(List<Connection> connections) {
        this.connections = List.copyOf(connections);
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
