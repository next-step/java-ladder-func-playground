package generator;

import java.util.ArrayList;
import java.util.List;

public class TestConnectionGenerator implements ConnectionGenerator {
    private final List<Boolean> connections;
    private int index;

    public TestConnectionGenerator(List<Boolean> connections) {
        this.connections = new ArrayList<>(connections);
        this.index = 0;
    }

    @Override
    public Boolean generate() {
        validateIndex();

        Boolean connection = connections.get(index);
        index++;
        skipAppendFalse(connection);

        return connection;
    }

    private void skipAppendFalse(Boolean connection) {
        if (connection && index < connections.size()) {
            index++;
        }
    }

    private void validateIndex() {
        if (index >= connections.size()) {
            throw new IllegalStateException("테스트용 연결 값이 부족합니다.");
        }
    }
}
