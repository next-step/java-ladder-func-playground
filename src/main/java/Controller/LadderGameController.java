package Controller;

import Domain.PlayerName;
import Domain.PlayerNames;
import Domain.PrizeNames;
import LadderDomain.Ladder;
import LadderDomain.LadderGame;
import View.InputHandler;
import View.OutputHandler;

public class LadderGameController {

    private final PlayerNames playerNames;
    private final LadderGame game;
    private final Ladder ladder;
    private final PrizeNames prizeNames;

    public LadderGameController(PlayerNames playerNames, LadderGame game, Ladder ladder, PrizeNames prizeNames) {
        this.playerNames = playerNames;
        this.game = game;
        this.ladder = ladder;
        this.prizeNames = prizeNames;
    }

    public void run() {
        OutputHandler.printLadder(playerNames, ladder, prizeNames);
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
            OutputHandler.printResults(playerNames, game.findAllResults());
            return;
        }

        PlayerName inputName = new PlayerName(input);
        if (playerNames.contains(inputName)) {
            OutputHandler.printSingleResult(game.findResultByName(inputName));
            return;
        }

        OutputHandler.printInvalidName();
    }
}
