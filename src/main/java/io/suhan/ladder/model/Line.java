package io.suhan.ladder.model;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Connection> connections;

    public Line(List<Connection> connections) {
        this.connections = connections;
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }
}
