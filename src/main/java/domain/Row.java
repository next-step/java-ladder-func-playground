package domain;

import generator.ConnectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int START_POSITION = 0;
    private static final int ONE_STEP = 1;
    private final List<Boolean> row;

    private Row(List<Boolean> connections) {
        this.row = new ArrayList<>(connections);
    }

    public static Row of(int length, ConnectionGenerator connectionGenerator) {
        List<Boolean> row = new ArrayList<>();

        for (int position = START_POSITION; position < length; position++) {
            row.add(canConnect(row, position, connectionGenerator));
        }
        return new Row(row);
    }

    public List<Boolean> getRow() {
        return new ArrayList<>(row);
    }

    public int move(int position) {
        if (position > START_POSITION && row.get(position - 1) == true) {
            return position - ONE_STEP;
        }
        if (position < row.size() && row.get(position) == true) {
            return position + ONE_STEP;
        }
        return position;
    }

    private static boolean canConnect(List<Boolean> row, int position, ConnectionGenerator connectionGenerator) {
        return isBeforeDisconnected(row, position)
                && connectionGenerator.generate();
    }

    private static boolean isBeforeDisconnected(List<Boolean> row, int position) {
        return position == START_POSITION || !row.get(position - ONE_STEP);
    }
}
