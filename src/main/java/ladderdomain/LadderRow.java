package ladderdomain;

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
        List<Connection> line = new java.util.ArrayList<>();
        List<Boolean> randomBoolean = generateRandomConnection(width - 1, generator);
        List<Boolean> filteredBoolean = removeConnection(randomBoolean);

        for (Boolean bool : filteredBoolean) {
            line.add(new Connection(bool));
        }

        return line;
    }

    private List<Boolean> generateRandomConnection(int size, BooleanValueGenerator generator) {
        List<Boolean> randomBoolean = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomBoolean.add(generator.generate());
        }
        return randomBoolean;
    }

    private List<Boolean> removeConnection(List<Boolean> original) {
        List<Boolean> result = new java.util.ArrayList<>();
        boolean wasTrue = false;

        for (Boolean current : original) {
            boolean valid = !wasTrue && current;
            result.add(valid);
            wasTrue = valid;
        }

        return result;
    }

    private boolean containsAtLeastOneTrue(List<Connection> line) {
        return line.stream().anyMatch(Connection::hasRight);
    }

    public int move(int index) {
        Direction direction = Direction.of(index, connections);
        return direction.move(index);
    }

    public List<Connection> getConnections() {
        return java.util.Collections.unmodifiableList(connections);
    }
}
