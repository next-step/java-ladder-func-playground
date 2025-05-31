import ladder.Height;
import ladder.Ladder;
import ladder.Width;
import strategy.LinkStrategy;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Height height, Width width, LinkStrategy linkStrategy) {
        this.ladder = new Ladder(height, width, linkStrategy);
    }

    public Ladder getLadder() {
        return ladder;
    }
}




