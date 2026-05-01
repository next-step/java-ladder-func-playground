package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderGenerator {

    private LadderGenerator() {
    }

    public static Ladder generate(LadderWidth width, LadderHeight height, BooleanGenerator generator) {
        Ladder ladder = createLadder(width, height, generator);
        while (hasEmptyInterval(ladder, width)) {
            ladder = createLadder(width, height, generator);
        }
        return ladder;
    }

    private static Ladder createLadder(LadderWidth width, LadderHeight height, BooleanGenerator generator) {
        List<Line> lines = new ArrayList<>();
        Line currentLine = Line.generateFirst(width, generator);
        lines.add(currentLine);
        return new Ladder(addRemainingLines(lines, width, height, generator, currentLine));
    }

    private static List<Line> addRemainingLines(List<Line> lines, LadderWidth width, LadderHeight height, BooleanGenerator generator, Line firstLine) {
        Line currentLine = firstLine;
        for (int i = 1; i < height.getValue(); i++) {
            currentLine = Line.generateNext(width, generator, currentLine);
            lines.add(currentLine);
        }
        return lines;
    }

    private static boolean hasEmptyInterval(Ladder ladder, LadderWidth width) {
        return IntStream.range(0, width.getIntervalCount())
                .anyMatch(index -> isEmptyInterval(ladder, index));
    }

    private static boolean isEmptyInterval(Ladder ladder, int index) {
        return ladder.getLines().stream().noneMatch(line -> line.isConnectedAt(index));
    }
}