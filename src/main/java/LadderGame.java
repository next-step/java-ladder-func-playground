import ladder.Ladder;
import strategy.LinkStrategy;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(int row, int column, LinkStrategy linkStrategy) {
        this.ladder = new Ladder(row, column, linkStrategy);
    }

    public Ladder getLadder() {
        return ladder;
    }
}




