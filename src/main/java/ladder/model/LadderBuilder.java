package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        if (cols <= 1) {
            return linkConnector.generate(width);
        }
        return createLine(width, prevLine, cols);
    }

    private List<Boolean> createLine(int width, List<Boolean> prevLine, int cols) {
        List<Boolean> nextLine = linkConnector.generate(width);
        boolean confilct = hasConflict(prevLine, nextLine, cols);

        while (confilct) {
            nextLine = linkConnector.generate(width);
            confilct = hasConflict(prevLine, nextLine, cols);
        }
        return nextLine;
    }

    private boolean hasConflict(List<Boolean> prevLine, List<Boolean> nextLine, int cols) {
        int num = 0;
        boolean confilct = false;
        while (num < cols) {
            confilct = confilct || (prevLine.get(num) && nextLine.get(num));
            num++;
        }
        return confilct;
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
            lines.get(randomRow).set(cols, true);
        }
    }
}
