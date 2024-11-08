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

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void runLadderApplication() {
        Players players = inputLadderGamePlayers();
        Prizes prizes = inputLadderGamePrizes(players);
        Ladder ladder = createLadder(players);

        showLadderGameBoard(players, ladder, prizes);

        LadderGame ladderGame = new LadderGame(players,ladder,prizes);
        ladderGame.playLadderGame();

        executeLadderResultConfirmationProcess(ladderGame);
    }

    private Players inputLadderGamePlayers() {
        return new Players(inputView.inputLadderGamePlayerNames());
    }

    private Prizes inputLadderGamePrizes(Players players) {
        return new Prizes(players.count(), inputView.inputLadderGamePrizes());
    }

    private Ladder createLadder(Players players) {
        return new Ladder(players.count(), inputView.inputLadderHeight());
    }

    private void showLadderGameBoard(Players players, Ladder ladder, Prizes prizes) {
        resultView.printLadderFormWithGameElements(players,ladder,prizes);
    }

    private void executeLadderResultConfirmationProcess(LadderGame ladderGame) {
        String playerName = inputView.inputSelectPlayerToKnowPrize();
        resultView.printLadderResult(playerName,ladderGame);
    }
}
