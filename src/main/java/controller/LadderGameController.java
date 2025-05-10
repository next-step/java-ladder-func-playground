package controller;

import domain.user.PlayerName;
import ladderdomain.LadderGame;
import domain.user.GameInformation;
import view.InputHandler;
import view.OutputHandler;

public class LadderGameController {

    private final GameInformation gameInformation;
    private final LadderGame game;

    public LadderGameController(LadderGame game, GameInformation gameInformation) {
        this.game = game;
        this.gameInformation = gameInformation;
    }

    public void run() {
        OutputHandler.printLadder(gameInformation.getPlayerNames(), game.getLadder(), gameInformation.getPrizeNames());
        handlePlayerResult();
    }

    private void handlePlayerResult() {
        String input = InputHandler.inputPlayerResult();
        while (!"exit".equals(input)) {
            parsePlayerResult(input);
            input = InputHandler.inputPlayerResult();
        }
    }

    private void parsePlayerResult(String input) {
        if ("all".equals(input)) {
            OutputHandler.printResults(gameInformation.getPlayerNames(), game.findAllResults());
            return;
        }

        PlayerName name = new PlayerName(input);
        if (gameInformation.getPlayerNames().contains(name)) {
            OutputHandler.printSingleResult(game.findResultByName(name));
            return;
        }

        OutputHandler.printInvalidName();
    }
}

