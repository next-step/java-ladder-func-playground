package controller;

import constants.ScriptConstants;
import model.Ladder;
import model.LadderBuilder;
import model.LadderGame;
import model.Players;
import model.Prizes;
import view.InputView;

public class GenerateLadderGameController {
    private final LadderBuilder ladderBuilder;
    private final InputView inputView;
    public GenerateLadderGameController(LadderBuilder ladderBuilder, InputView inputView) {
        this.ladderBuilder = ladderBuilder;
        this.inputView = inputView;
    }

    public LadderGame generateLadderGame() {
        Players players = new Players(inputView.getListOfStringAfterShowingScript(ScriptConstants.ENTER_USER));
        Prizes prizes = new Prizes(inputView.getListOfStringAfterShowingScript(ScriptConstants.ENTER_PRIZE));
        int height= inputView.getSingleIntegerFromUserAfterShowingAScript(ScriptConstants.INPUT_HEIGHT_SCRIPT);
        Ladder ladder = ladderBuilder.generateLadder(height, players.playerCount());

        return new LadderGame(players, prizes, ladder);
    }
}
