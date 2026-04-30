package domain;

import generator.ConnectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int START_POSITION = 0;
    private final List<Boolean> row;

    private Row(List<Boolean> connections) {
        this.row = new ArrayList<>(connections);
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

    public int move(int position) {
        if (position > START_POSITION && row.get(position - 1) == true) {
            return position - 1;
        }
        if (position < row.size() && row.get(position) == true) {
            return position + 1;
        }
        return position;
    }

    private static void appendFalse(List<Boolean> row, boolean isConnected, int length) {
        if (isConnected && row.size() < length) {
            row.add(false);
        }
    }
}
