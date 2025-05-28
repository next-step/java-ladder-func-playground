package domain;

import java.util.List;

public class Line {
    private final List<Connection> connections;

    public Line(List<Connection> connections) {
        validate(connections);
        this.connections = connections;
    }

    private void validate(List<Connection> connections) {
        for (int i = 0; i < connections.size() - 1; i++) {
            boolean curr = connections.get(i).isConnectedRight();
            boolean next = connections.get(i + 1).isConnectedRight();
            if (curr && next) {
                throw new IllegalArgumentException("사다리 가로선에 연속된 연결선이 존재합니다.");
            }
        }
    }

    public List<Connection> getConnections() {
        return List.copyOf(connections);
    }
}
