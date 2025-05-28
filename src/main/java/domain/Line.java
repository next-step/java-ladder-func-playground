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

    public int move(int index) {
        if (canMoveRight(index)) {
            return index + 1;
        }
        if (canMoveLeft(index)) {
            return index - 1;
        }
        return index;
    }

    private boolean canMoveRight(int index) {
        return index < connections.size() && connections.get(index).isConnectedRight();
    }

    private boolean canMoveLeft(int index) {
        return index > 0 && connections.get(index - 1).isConnectedRight();
    }

    public List<Connection> getConnections() {
        return List.copyOf(connections);
    }
}
