package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderBuilder {
    private final LinkConnector linkConnector;
    private final Random random = new Random();

    public LadderBuilder(LinkConnector linkConnector) {
        this.linkConnector = linkConnector;
    }

    public Ladder build(int width, int height) {
        List<List<Boolean>> generatedLines = new ArrayList<>();

        generatedLines.add(linkConnector.generate(width));

        int col = width - 1;

        for (int i = 1; i < height; i++) {
            List<Boolean> prevLine = generatedLines.get(i - 1);
            List<Boolean> nextLine = duplicationLine(width, prevLine, col);
            generatedLines.add(nextLine);
        }

        fillEmptySpace(generatedLines, width, height);

        return new Ladder(generatedLines);
    }

    private List<Boolean> duplicationLine(int width, List<Boolean> prevLine, int cols) {
        List<Boolean> nextLine = linkConnector.generate(width);

        boolean b = IntStream.range(0, cols)
                .anyMatch(j -> prevLine.get(j) && nextLine.get(j));

        if (b) {
            return duplicationLine(width, prevLine, cols);
        }
        return nextLine;
    }

    private void fillEmptySpace(List<List<Boolean>> lines, int width, int height) {
        int col = width - 1;
        boolean[] hasBridgeInColumn = new boolean[col];

        for (List<Boolean> line : lines) {
            for (int j = 0; j < col; j++) {
                hasBridgeInColumn[j] = hasBridgeInColumn[j] || line.get(j);
            }
        }

        List<Integer> missingCols = new ArrayList<>();
        for (int j = 0; j < col; j++) {
            if (!hasBridgeInColumn[j]) {
                missingCols.add(j);
            }
        }

        for (int cols : missingCols) {
            int randomRow = random.nextInt(height);
            lines.get(randomRow).set(col, true);
        }
    }
}
