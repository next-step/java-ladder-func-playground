package Controller;

import Domain.Name;
import Domain.Players;
import Domain.Results;
import LadderDomain.Ladder;
import LadderDomain.LadderGame;
import View.InputHandler;
import View.OutputHandler;

public class LadderApplication {
    public static void main(String[] args) {
        Players players = InputHandler.readPlayersUntilValid();
        Results results = InputHandler.readResultsUntilValid(players.size());
        int height = InputHandler.readHeightUntilValid();

        Ladder ladder = new Ladder(height, players.size());
        LadderGame game = new LadderGame(players, ladder, results);

        OutputHandler.printLadder(players, ladder, results);

        processQueries(players, game);
    }

    private static void processQueries(Players players, LadderGame game) {
        String input = InputHandler.readQuery();
        while (!"exit".equals(input)) {
            handleQuery(input, players, game);
            input = InputHandler.readQuery();
        }
    }

    private static void handleQuery(String input, Players players, LadderGame game) {
        if ("all".equals(input)) {
            OutputHandler.printResults(game.findAllResults());
            return;
        }
        Name queryName = new Name(input);
        if (players.contains(queryName)) {
            OutputHandler.printSingleResult(game.findResultByName(queryName));
            return;
        }
        OutputHandler.printInvalidName();
    }
}

