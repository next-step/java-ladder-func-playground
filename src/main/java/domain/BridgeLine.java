package domain;

import java.util.Collections;
import java.util.List;

public class BridgeLine {

    private static final String ERROR_INVALID_CONNECTIONS = "[ERROR] 가로줄 연결 상태는 null이거나 비어 있을 수 없습니다.";

    private final List<Boolean> horizontalConnections;

    public BridgeLine(List<Boolean> horizontalConnections) {
        validate(horizontalConnections);
        this.horizontalConnections = Collections.unmodifiableList(horizontalConnections);
    }

    public boolean isConnectedAt(int index) {
        if (index < 0 || index >= horizontalConnections.size()) {
            return false;
        }
        return horizontalConnections.get(index);
    }

    public int width() {
        return horizontalConnections.size();
    }

    public int nextPositionFrom(int position) {
        if (position > 0 && isConnectedAt(position - 1)) {
            return position - 1;
        }

        if (position < width() && isConnectedAt(position)) {
            return position + 1;
        }

        return position;
    }

    private void validate(List<Boolean> connections) {
        if (connections == null || connections.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_CONNECTIONS);
        }
    }
}
