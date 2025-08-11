package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Row {
    private final List<Connection> connections;

    private Row(List<Connection> connections) {
        this.connections = Collections.unmodifiableList(new ArrayList<>(connections));
    }

    public static Row of(List<Connection> connections) {
        validate(connections);
        return new Row(connections);
    }

    private static void validate(List<Connection> connections) {
        Connection previous = Connection.EMPTY;
        for (Connection current : connections) {
            if (previous == Connection.CONNECTED && current == Connection.CONNECTED) {
                throw new IllegalArgumentException("인접한 연결은 허용되지 않습니다");
            }
            previous = current;
        }
    }

    public List<Connection> connections() {
        return connections;
    }
}


