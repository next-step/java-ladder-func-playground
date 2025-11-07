package model.ladder;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public int trace(int startColumn) {
        int currentColumn = startColumn;
        for (int row = 0; row < ladder.getHeight(); row++) {
            Line currentLine = ladder.getLine(row);
            currentColumn = moveColumn(currentLine, currentColumn);
        }
        return currentColumn;
    }

    private int moveColumn(Line currentLine, int currentColumn) {
        if (currentColumn > 0 && currentLine.isConnectedAt(currentColumn - 1)) {
            return currentColumn - 1;
        }
        if (currentColumn < currentLine.getPointCount() && currentLine.isConnectedAt(currentColumn)) {
            return currentColumn + 1;
        }
        return currentColumn;
    }
}
