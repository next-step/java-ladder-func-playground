package controller;

import java.util.Map;

import domain.LadderGame;
import domain.Players;
import domain.Prizes;
import dto.LadderGameResponse;
import util.Parser;
import view.InputView;
import view.ResultView;

public class LadderController {

    private static final String ALL_PLAYER = "all";

    public void run() {
        Players players = Parser.parsePlayers(InputView.inputPlayers());
        Prizes prizes = Parser.parsePrizes(InputView.inputPrizes());
        int height = Parser.parseHeight(InputView.inputHeight());

        LadderGame ladderGame = new LadderGame(players, prizes, height);

        ResultView.outputLadder(LadderGameResponse.from(ladderGame));
        outputResult(ladderGame);
    }

    private void outputResult(LadderGame ladderGame) {
        String playerName = InputView.inputPlayerName();
        Map<String, String> ladderGameResult = ladderGame.calculateResult();

        if (playerName.equals(ALL_PLAYER)) {
            ResultView.outputAllPlayerResult(ladderGameResult);
            return;
        }
        ResultView.outputPlayerResult(playerName, ladderGameResult);
    }
}
