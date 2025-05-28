import ladder.Ladder;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(int row, int column) {
        this.ladder = new Ladder(row, column);
    }

    public void initialize() {
        ladder.generateLadder();
    }

    public Ladder getLadder() {
        return ladder;
    }
}




