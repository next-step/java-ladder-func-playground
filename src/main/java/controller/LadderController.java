package controller;

import java.util.List;

import domain.LadderGame;
import domain.Player;
import domain.Prize;
import util.Parser;
import view.InputView;
import view.ResultView;

public class LadderController {

    public void run() {
        List<Player> players = Parser.parsePlayers(InputView.inputPlayers());
        List<Prize> prizes = Parser.parsePrizes(InputView.inputPrizes());
        int height = Parser.parseHeight(InputView.inputHeight());

        LadderGame ladderGame = new LadderGame(players, prizes, height);

        ResultView.outputLines(ladderGame);
        ResultView.outputResult(InputView.inputResult(), ladderGame);
    }
}
