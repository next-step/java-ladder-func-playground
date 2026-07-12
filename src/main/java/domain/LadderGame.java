package domain;

import java.util.List;

public class LadderGame {

    private final LadderLines ladderLines;

    public LadderGame(LadderLines ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static LadderGame of(int width, LadderHeight height, RandomStrategy strategy) {
        return new LadderGame(LadderLines.of(width, height, strategy));
    }

    public int getFinalPosition(int startPosition) {
        return ladderLines.getFinalPosition(startPosition);
    }

    public List<LadderLine> getLadderStructure() {
        return ladderLines.getLines();
    }
}
