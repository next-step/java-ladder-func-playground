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

    public int[] resultIndex(Ladder ladder) {
        List<List<Boolean>> lines = ladder.getLines();
        int height = lines.size();
        int cols = 0;
        if (height > 0) {
            cols = lines.get(0).size();
        }
        int width = cols + 1;
        int[] positions = new int[width];

        for (int i = 0; i < width; i++) {
            positions[i] = i;
        }

        // depth가 2를 넘어가네... 수정
        for (List<Boolean> line : lines) {
            for (int col = 0; col < cols; col++) {
                if (line.get(col)) {
                    int tmp = positions[col];
                    positions[col] = positions[col + 1];
                    positions[col + 1] = tmp;
                }
            }
        }

        int[] result = new int[width];
        for (int col = 0; col < width; col++) {
            result[positions[col]] = col;
        }

        return result;
    }
}
