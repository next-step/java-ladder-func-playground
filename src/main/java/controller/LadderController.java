package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.Players;
import domain.Results;
import view.InputView;
import view.OutputView;

import java.util.InputMismatchException;
import java.util.Random;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Players inputPlayers() {
        outputView.printAskPlayers();
        while (true) {
            try {
                return new Players(inputView.readString());
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
                outputView.printRetryInputMessage();
            }
        }
    }

    public Results inputResults(Players players) {
        outputView.printAskResults();
        while (true) {
            try {
                Results results = new Results(inputView.readString());
                LadderGame.validatePlayerAndResultCount(players, results);
                return results;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
                outputView.printRetryInputMessage();
            }
        }
    }

    public Height inputHeight() {
        outputView.printAskHeight();
        while (true) {
            try {
                return new Height(inputView.readInt());
            } catch (InputMismatchException | IllegalArgumentException e) {
                outputView.printException(e);
                outputView.printRetryInputMessage();
            }
        }
    }

    public LadderGame startLadderGame(Height height, Players players, Results results) {
        Ladder ladder = new Ladder(height, players.size(), new Random());
        LadderGame game = new LadderGame(ladder, players, results);
        outputView.printLadderResultTitle();
        outputView.printLadder(ladder
                , players.getPlayers().getValues()
                , results.getResults().getValues());
        return game;
    }

    public void showResult(LadderGame game, Players players) {
        boolean run = true;
        while (run) {
            outputView.printAskResultByPlayer();
            String name = inputView.readString();
            run = validateRun(game, players, name);
        }
    }

    private boolean validateRun(LadderGame game, Players players, String name) {
        if (name.equals("all")) {
            outputView.printAllResults(game.findAll(), players);
            return false;
        }
        String result = game.findResultByPlayer(name);
        outputView.printSingleResult(result);
        return true;
    }
}
