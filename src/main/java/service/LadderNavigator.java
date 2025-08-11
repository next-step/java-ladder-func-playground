package service;

import java.util.ArrayList;
import java.util.List;

import domain.Columns;
import domain.Connection;
import domain.Ladder;
import domain.Row;

public final class LadderNavigator {
    public int traverse(Ladder ladder, Columns columns, int startColumn) {
        int currentColumn = startColumn;
        for (Row row : ladder.rows()) {
            if (currentColumn < columns.numberOfSegments()
                    && row.connections().get(currentColumn) == Connection.CONNECTED) {
                currentColumn += 1;
                continue;
            }
            if (currentColumn > 0
                    && row.connections().get(currentColumn - 1) == Connection.CONNECTED) {
                currentColumn -= 1;
            }
        }
        return currentColumn;
    }

    public List<Integer> traverseAll(Ladder ladder, Columns columns) {
        List<Integer> results = new ArrayList<>();
        for (int start = 0; start < columns.count(); start++) {
            results.add(traverse(ladder, columns, start));
        }
        return results;
    }
}


