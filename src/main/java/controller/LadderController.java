package controller;

import model.LadderGame;
import model.ladder.Ladder;
import model.player.Players;
import model.prize.Prizes;
import view.InputView;
import view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;

    private Players players;
    private Prizes prizes;
    private Ladder ladder;
    private LadderGame ladderGame;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void runLadderApplication() {
        inputLadderGameElementsInformation();
        showLadderGameBoard();

        playLadderGame();

        executeLadderResultConfirmationProcess();
    }

    private void inputLadderGameElementsInformation() {
        players = new Players(inputView.inputLadderGamePlayerNames());
        prizes = new Prizes(players.Count(),inputView.inputLadderGamePrizes());
        ladder = new Ladder(players.Count(), inputView.inputLadderHeight());
    }

    private void showLadderGameBoard() {
        resultView.printLadderFormWithGameElements(players,ladder,prizes);
    }

    private void playLadderGame() {
        ladderGame = new LadderGame(players,ladder,prizes);
        ladderGame.playLadderGame();
    }

    private void executeLadderResultConfirmationProcess() {
        String playerName = inputView.inputSelectPlayerToKnowPrize();
        resultView.printLadderResult(playerName,ladderGame);
    }


}
