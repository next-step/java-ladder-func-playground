package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.RandomLadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    public void play() {
        int width = InputView.getWidth();
        int height = InputView.getHeight();
        Ladder ladder = new Ladder(new RandomLadderGenerator(width, height));
        OutputView.printLadder(ladder.getLadder());
        LadderGame ladderGame = new LadderGame(ladder, width);
        ladderGame.move();
        OutputView.printResult(ladderGame.getResult());
    }
}
