package domain;

import generator.ConnectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private final List<Boolean> row;

    public Row(List<Boolean> connections) {
        this.row = connections;
    }

    public static Row of(int length, ConnectionGenerator connectionGenerator) {
        List<Boolean> row = new ArrayList<>();
        while (row.size() < length) {
            boolean isConnected = connectionGenerator.generate();
            row.add(isConnected);
            appendFalse(row, isConnected, length);
        }
        return new Row(row);
    }

    public List<Boolean> getRow() {
        return new ArrayList<>(row);
    }

    private static void appendFalse(List<Boolean> row, boolean isConnected, int length) {
        if (isConnected && row.size() < length) {
            row.add(false);
        }
    }
}
