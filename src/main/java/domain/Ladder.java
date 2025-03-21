package domain;

import utils.RandomUtil;
import utils.generator.LadderGenerator;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(int width, int height) {
        return new Ladder(LadderGenerator.generate(width, height));
    }

    public Lines getLines() {
        return lines;
    }

    public static void validate(List<Line> lines, int width) {
        IntStream.rangeClosed(0, width)
                .forEach(i -> validateColumn(lines, i, width));
    }

    private static void validateColumn(List<Line> lines, int col, int width) {
        boolean emptyColumn = lines.stream().noneMatch(line -> hasBridgeAt(line, col, width));
        if (emptyColumn) {
            int randomIndex = RandomUtil.nextInt(lines.size());
            connect(lines, randomIndex, col, width);
        }
    }

    private static boolean hasBridgeAt(Line line, int col, int width) {
        if (col == 0) return line.hasBridgeAt(col);
        if (col == width) return line.hasBridgeAt(col - 1);
        return line.hasBridgeAt(col - 1) || line.hasBridgeAt(col);
    }

    private static void connect(List<Line> lines, int randomIndex, int col, int width) {
        Line oldLine = lines.get(randomIndex);

        int index = col;
        if (col == width) {
            index = col - 1;
        }

        Line updatedLine = oldLine.setBridgeAt(index);
        lines.set(randomIndex, updatedLine);
    }
}
