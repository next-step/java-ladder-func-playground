package model;

import java.util.*;
import java.util.stream.*;

public class LadderValidator {
    private static final Random RANDOM = new Random();

    public static void validate(List<Line> lines, int width) {
        IntStream.rangeClosed(0, width)
                .forEach(i -> validateColumn(lines, i, width));
    }

    private static void validateColumn(List<Line> lines, int col, int width) {
        boolean emptyColumn = lines.stream().noneMatch(line -> hasBridgeAt(line, col, width));
        if (emptyColumn) {
            connect(lines.get(RANDOM.nextInt(lines.size())), col, width);
        }
    }

    private static boolean hasBridgeAt(Line line, int col, int width) {
        if (col == 0) return line.hasBridgeAt(col);
        if (col == width) return line.hasBridgeAt(col - 1);
        return line.hasBridgeAt(col - 1) || line.hasBridgeAt(col);
    }


    private static void connect(Line line, int col, int width) {
        if (col == width) line.setBridgeAt(col - 1);
        else line.setBridgeAt(col);
    }
}
