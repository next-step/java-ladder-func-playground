package ladderdomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LadderRow {

    private final List<Connection> connections;

    public LadderRow(int width, BooleanValueGenerator generator) {
        this.connections = generateValidLine(width, generator);
    }

    private List<Connection> generateValidLine(int width, BooleanValueGenerator generator) {
        List<Connection> line = generateLine(width, generator);
        while (!containsAtLeastOneTrue(line)) {
            line = generateLine(width, generator);
        }
        return line;
    }

    private List<Connection> generateLine(int width, BooleanValueGenerator generator) {
        List<Connection> line = new ArrayList<>();
        int index = 0;
        List<Boolean> randomBoolean = generateRandomConnection(width - 1, generator);

        List<Boolean> filteredBoolean = removeConnection(randomBoolean);

        while (index < filteredBoolean.size()) {
            line.add(new Connection(filteredBoolean.get(index)));
            index++;
        }

        return line;
    }

    private List<Boolean> generateRandomConnection(int size, BooleanValueGenerator generator) {
        List<Boolean> randomBoolean = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomBoolean.add(generator.generate());
        }
        return randomBoolean;
    }

    private List<Boolean> removeConnection(List<Boolean> original) {  //라인이 한 줄로 겹치지 않기 위해서
        List<Boolean> result = new ArrayList<>();
        boolean wasTrue = false;

        for (Boolean current : original) {
            result.add(skipConnection(current, wasTrue));
            wasTrue = result.get(result.size() - 1);
        }

        return result;
    }

    private boolean skipConnection(boolean current, boolean wasTrue) {
        if (wasTrue) {
            return false;
        }
        return current;
    }

    private boolean containsAtLeastOneTrue(List<Connection> line) {
        return line.stream().anyMatch(Connection::hasRight);
    }

    public int move(int index) {
        if (index < connections.size() && connections.get(index).hasRight()) {
            return index + 1;
        }
        if (index > 0 && connections.get(index - 1).hasRight()) {
            return index - 1;
        }
        return index;
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }
}
