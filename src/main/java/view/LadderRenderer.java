package view;

import java.util.ArrayList;
import java.util.List;

import domain.Columns;
import domain.Connection;
import domain.Ladder;
import domain.Row;
import domain.RungLength;

public final class LadderRenderer {
    private static final String NAME_HEADER_INDENT = "  ";
    private static final String BODY_INDENT = "    ";

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
            System.out.println(BODY_INDENT + line);
        }
    }

    public String renderNamesHeader(List<String> names, RungLength rungLength) {
        StringBuilder builder = new StringBuilder();
        builder.append(NAME_HEADER_INDENT);
        for (String name : names) {
            builder.append(padCell(name, rungLength));
        }
        return builder.toString().stripTrailing();
    }

    public String renderBottomLabels(List<String> labels, RungLength rungLength) {
        StringBuilder builder = new StringBuilder();
        builder.append(BODY_INDENT);
        for (String label : labels) {
            builder.append(padCell(label, rungLength));
        }
        return builder.toString().stripTrailing();
    }

    private String padCell(String text, RungLength rungLength) {
        int width = rungLength.length();
        String value = text == null ? "" : text;
        if (value.length() > width) {
            value = value.substring(0, width);
        }
        int padding = width - value.length();
        StringBuilder builder = new StringBuilder();
        builder.append(value);
        for (int i = 0; i < padding; i++) {
            builder.append(' ');
        }
        builder.append(' ');
        return builder.toString();
    }
}


