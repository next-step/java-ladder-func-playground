package ladder;

import strategy.LinkStrategy;
import tuner.LadderTuner;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public LadderGame(Row rows, Column columns, LinkStrategy linkStrategy, LadderTuner tuner) {
        this.ladder = new Ladder(rows, columns, linkStrategy, tuner);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public int play(int start) {
        int position = start;
        for (int row = 0; row < ladder.rowCount(); row++) {
            position = movePosition(position, ladder.lineAt(row));
        }
        return position;
    }

    private int movePosition(int position, Line line) {
        Direction direction = getDirection(position, line);
        return direction.move(position);
    }

    private Direction getDirection(int position, Line line) {
        if (canMoveLeft(position, line)) {
            return Direction.LEFT;
        }
        if (canMoveRight(position, line)) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private boolean canMoveLeft(int position, Line line) {
        return position > 0 && line.isLinkedAt(position - 1);
    }

    private boolean canMoveRight(int position, Line line) {
        return position < line.getLinks().size() && line.isLinkedAt(position);
    }
}




