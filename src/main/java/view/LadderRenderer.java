package view;

import java.util.ArrayList;
import java.util.List;

import domain.Columns;
import domain.Connection;
import domain.Ladder;
import domain.Row;
import domain.RungLength;

public final class LadderRenderer {
    public List<String> renderLines(Ladder ladder, Columns columns, RungLength rungLength) {
        List<String> lines = new ArrayList<>();
        for (Row row : ladder.rows()) {
            lines.add(renderRow(row, columns, rungLength));
        }
        return lines;
    }

    private String renderRow(Row row, Columns columns, RungLength rungLength) {
        StringBuilder builder = new StringBuilder();
        int segmentCount = columns.numberOfSegments();
        for (int i = 0; i < segmentCount; i++) {
            builder.append('|');
            appendSpan(builder, row.connections().get(i), rungLength);
        }
        builder.append('|');
        return builder.toString();
    }

    private void appendSpan(StringBuilder builder, Connection connection, RungLength rungLength) {
        if (connection == Connection.CONNECTED) {
            builder.append(rungLength.dashes());
            return;
        }
        builder.append(rungLength.spaces());
    }

    public void print(Ladder ladder, Columns columns, RungLength rungLength) {
        List<String> lines = renderLines(ladder, columns, rungLength);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}


