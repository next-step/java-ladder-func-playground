package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.Columns;
import domain.Connection;
import domain.Ladder;
import domain.Row;
import domain.Rows;

public final class RandomConnectionGenerator {
    private final Random random;

    public RandomConnectionGenerator(Random random) {
        this.random = random;
    }

    public Row generateRow(Columns columns) {
        List<Connection> list = new ArrayList<>();
        Connection previous = Connection.EMPTY;
        for (int i = 0; i < columns.numberOfSegments(); i++) {
            Connection next = nextConnection(previous);
            list.add(next);
            previous = next;
        }
        return Row.of(list);
    }

    private Connection nextConnection(Connection previous) {
        if (previous == Connection.CONNECTED) {
            return Connection.EMPTY;
        }
        boolean connect = random.nextBoolean();
        if (connect) {
            return Connection.CONNECTED;
        }
        return Connection.EMPTY;
    }

    public Ladder generateLadder(Rows rows, Columns columns) {
        List<Row> rowList = new ArrayList<>();
        for (int r = 0; r < rows.count(); r++) {
            rowList.add(generateRow(columns));
        }
        return Ladder.of(rowList);
    }
}


