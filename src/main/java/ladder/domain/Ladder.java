package ladder.domain;

import java.util.List;

public class Ladder {
    private List<Line> ladder;

    public Ladder(LadderGenerator ladderGenerator) {
        this.ladder = ladderGenerator.generateLadder();
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
