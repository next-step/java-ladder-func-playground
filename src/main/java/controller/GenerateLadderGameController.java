package controller;

import constants.ScriptConstants;
import model.Ladder;
import model.LadderBuilder;
import model.LadderGame;
import model.Player;
import model.Prize;
import view.InputView;

public class GenerateLadderGameController {
    private final LadderBuilder ladderBuilder;
    private final InputView inputView;
    public GenerateLadderGameController(LadderBuilder ladderBuilder, InputView inputView) {
        this.ladderBuilder = ladderBuilder;
        this.inputView = inputView;
    }

    public LadderGame generateLadderGame() {
        Player player = new Player(inputView.getListOfStringAfterShowingScript(ScriptConstants.ENTER_USER));
        Prize prize = new Prize(inputView.getListOfStringAfterShowingScript(ScriptConstants.ENTER_PRIZE));
        int height= inputView.getSingleIntegerFromUserAfterShowingAScript(ScriptConstants.INPUT_HEIGHT_SCRIPT);
        Ladder ladder = ladderBuilder.generateLadder(height, player.entryCount());

        return new LadderGame(player, prize, ladder);
    }
}
