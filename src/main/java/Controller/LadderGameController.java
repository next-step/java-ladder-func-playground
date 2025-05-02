package Controller;

import Domain.PlayerName;
import Domain.Players;
import Domain.Result;
import LadderDomain.Ladder;
import LadderDomain.LadderGame;
import View.InputHandler;
import View.OutputHandler;

public class LadderGameController {

    private final Players players;
    private final LadderGame game;
    private final Ladder ladder;
    private final Result result;

    public LadderGameController(Players players, LadderGame game, Ladder ladder, Result result) {
        this.players = players;
        this.game = game;
        this.ladder = ladder;
        this.result = result;
    }

    public void run() {
        OutputHandler.printLadder(players, ladder, result);
        playerResultInput();
    }

    private void playerResultInput() {
        String input = InputHandler.inputPlayerResult();
        while (!"exit".equals(input)) {
            printResult(input);
            input = InputHandler.inputPlayerResult();
        }
    }

    private void printResult(String input) {
        if ("all".equals(input)) {
            OutputHandler.printResults(game.findAllResults());
            return;
        }

        PlayerName inputName = new PlayerName(input);
        if (players.contains(inputName)) {
            OutputHandler.printSingleResult(game.findResultByName(inputName));
            return;
        }

        OutputHandler.printInvalidName();
    }
}
