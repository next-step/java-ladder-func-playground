package ladder.model;

import java.util.List;

public class LadderResult {

    public void printResult(Ladder ladder) {
        List<List<Boolean>> lines = ladder.getLines();
        int width = 0;
        if (!lines.isEmpty()) {
            width = lines.get(0).size() + 1;
        }

        for (int startLine = 0; startLine < width; startLine++) {
            int currentPosition = endPosition(startLine, lines);
            System.out.println(startLine + " -> " + currentPosition);
        }
    }

    private int endPosition(int start, List<List<Boolean>> lines) {
        int currentPosition = start;
        for (List<Boolean> line : lines) {
            currentPosition = move(currentPosition, line);
        }
        return currentPosition;
    }

    private int move(int currentPosition, List<Boolean> line) {
        boolean rightPosition = currentPosition < line.size() && line.get(currentPosition);
        boolean leftPosition = currentPosition > 0 && line.get(currentPosition - 1);

        if (rightPosition) return currentPosition + 1;
        if (leftPosition) return currentPosition - 1;
        return currentPosition;
    }
}
