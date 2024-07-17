package domain;

import view.InputView;
import view.OutputView;

public class LadderGame {

    private final LadderMaker ladderMaker = new LadderMaker();

    public void runGame() {
        int width = InputView.printWidthCount();
        int height = InputView.printHeightCount();
        Ladder ladder = createLadder(width, height);
        OutputView.printLadder(ladder);
    }

    public Ladder createLadder(int width, int height) {
        return ladderMaker.createLadder(width, height);
    }
}
