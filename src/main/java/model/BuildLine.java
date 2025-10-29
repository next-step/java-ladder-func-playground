package model;

import java.util.Objects;

public final class BuildLine {

    public static final int LADDER_LINE = 5;

    public static String build(Line line) {
        Objects.requireNonNull(line);
        StringBuilder b = new StringBuilder();
        for (Point p : line.points()) {
            b.append("|");
            String fill = p.isConnected() ? "-".repeat(LADDER_LINE) : " ".repeat(LADDER_LINE);
            b.append(fill);
        }
        b.append("|");
        return b.toString();
    }
}
