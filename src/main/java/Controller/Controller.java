package Controller;

import java.util.List;

import Domain.Ladder;
import Domain.Player;
import View.InputHandler;
import View.OutputHandler;
import View.ResultHandler;

public class Controller {
    public void run() {
        InputHandler inputHandler = new InputHandler();

        List<Player> players = inputHandler.askPlayers();
        List<String> results = inputHandler.askResults(players.size());
        int width = players.size();
        int height = inputHandler.askHeight();

        Ladder ladder = new Ladder(width, height);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printLadder(players, ladder, results);

        ResultHandler resultHandler = new ResultHandler(players, results, ladder);
        resultHandler.handleResults(inputHandler);
    }
}
