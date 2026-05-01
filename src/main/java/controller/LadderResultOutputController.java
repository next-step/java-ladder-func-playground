package controller;

import model.LadderGame;
import view.OutputView;

public class LadderResultOutputController {
    private final LadderGame ladderGame;
    private final OutputView outputView;

    public LadderResultOutputController(LadderGame ladderGame, OutputView outputView) {
        this.ladderGame = ladderGame;
        this.outputView = outputView;
    }

    public void printFullLadder() {
        outputView.printFullLadderInGame(ladderGame.toString());
    }
}
