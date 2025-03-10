package utils.generator;

import domain.Line;
import domain.Lines;
import utils.validator.LadderValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LineGenerator {
    public static Lines generate(int width, int height) {
        List<Set<Integer>> reserved = ReservedPositionGenerator.generate(width - 1, height);
        List<Line> lines = new ArrayList<>();

        for (int row = 0; row < height; row++) {
            Line previous = getPreviousLine(lines, row);
            Line line = SingleLineGenerator.generate(width - 1, reserved.get(row), previous);
            lines.add(line);
        }

        LadderValidator.validate(lines, width - 1);
        return new Lines(lines);
    }

    private static Line getPreviousLine(List<Line> lines, int row) {
        if (row == 0) {
            return null;
        }
        return lines.get(row - 1);
    }
}
