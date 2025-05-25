package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeLine {

    private static final String VERTICAL_BAR = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String ERROR_INVALID_CONNECTIONS = "[ERROR] 가로줄 연결 상태는 null이거나 비어 있을 수 없습니다.";

    private final List<Boolean> horizontalConnections;

    public BridgeLine(List<Boolean> horizontalConnections) {
        validate(horizontalConnections);
        this.horizontalConnections = Collections.unmodifiableList(horizontalConnections);
    }

    public boolean isConnectedAt(int index) {
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

    public String drawLineFormat(int columnCount) {
        return IntStream.range(0, columnCount)
                .mapToObj(i -> VERTICAL_BAR + renderBridge(i))
                .collect(Collectors.joining());
    }

    private String renderBridge(int index) {
        if (index >= horizontalConnections.size()) {
            return EMPTY_LINE;
        }

        if (horizontalConnections.get(index)) {
            return CONNECTED_LINE;
        }

        return EMPTY_LINE;
    }

    private void validate(List<Boolean> connections) {
        if (connections == null || connections.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_CONNECTIONS);
        }
    }
}
