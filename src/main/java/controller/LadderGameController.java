package controller;

import constants.LadderConstants;
import constants.ScriptConstants;
import dto.GameResultDto;
import model.Ladder;
import model.LadderGame;
import model.Player;
import model.Prize;
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

            GameResultDto gameResultDto = ladderGame.checkSingleEntry(entry);
            outputView.printSingleString(ScriptConstants.RESULT_HEADER);
            outputView.printSingleString(gameResultDto.prizeEntry());
        }
    }

    private void printAllResult() {
        List<GameResultDto> gameResultDtos = ladderGame.calculateEveryResult();
        outputView.printSingleString(ScriptConstants.RESULT_HEADER);
        for (GameResultDto gameResultDto : gameResultDtos) {
            outputView.printSingleString(gameResultDto.toString());
        }
    }
}
