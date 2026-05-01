package controller;

import constants.LadderConstants;
import constants.ScriptConstants;
import dto.GameResultDto;
import model.LadderGame;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGame ladderGame;

    public LadderGameController(InputView inputView, OutputView outputView, LadderGame ladderGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGame = ladderGame;
    }

    public void playGame() {
        while (true) {
            String entry = inputView.getStringFromUserAfterShowingScript(ScriptConstants.ENTER_USER_QUERY);

            if (entry.equals(LadderConstants.ALL)) {
                printAllResult();
                return;
            }

            GameResultDto gameResultDto = ladderGame.checkSinglePlayer(entry);
            outputView.printPlayerResult(gameResultDto);
        }
    }

    private void printAllResult() {
        List<GameResultDto> gameResultDtos = ladderGame.calculateEveryResult();
        outputView.printAllPlayerResult(gameResultDtos);
    }
}
