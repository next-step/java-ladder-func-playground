package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Ladder {
    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        this.rows = Collections.unmodifiableList(new ArrayList<>(rows));
    }

    public static Ladder of(List<Row> rows) {
        return new Ladder(rows);
    }

    public List<Row> rows() {
        return rows;
    }
}


