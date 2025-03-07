package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderHeight;
import domain.LadderWidth;
import domain.Players;
import domain.Prizes;
import domain.GameResult;
import view.InputView;
import view.OutputView;

public class LadderController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Players players = inputView.askPlayers();
        Prizes prizes = inputView.askPrizes();
        LadderHeight height = inputView.askHeight();
        LadderWidth width = new LadderWidth(players.size());
        LadderGame ladderGame = new LadderGame(players, prizes, new Ladder(height, width));
        outputView.printLadderGameBoard(ladderGame);
        GameResult gameResult = ladderGame.play();
        String query = inputView.askResultName();
        if (query.equals("all")) {
            outputView.printResultAll(gameResult);
            return;
        }
        outputView.printResultSingle(gameResult.getResultByPlayerName(query).getPrize());
    }
}
