package ladder;

import strategy.LinkStrategy;
import tuner.LadderTuner;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Height height, Width width, LinkStrategy linkStrategy, LadderTuner tuner) {
        this.ladder = new Ladder(height, width, linkStrategy, tuner);
    }

    public Ladder getLadder() {
        return ladder;
    }
}




