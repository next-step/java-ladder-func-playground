package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.PlayerName;
import domain.Players;
import domain.ResultName;
import domain.Results;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
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
                String input = inputView.readString();
                List<PlayerName> players = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(PlayerName::new)
                        .toList();
                return new Players(players);
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
                String input = inputView.readString();
                List<ResultName> result = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(ResultName::new)
                        .toList();
                Results results = new Results(result);
                LadderGame.validatePlayerAndResultCount(players, results);
                return results;
            } catch (IllegalArgumentException e) {
                outputView.printException(e);
                outputView.printRetryInputMessage();
            }
        }
    }

    public int inputHeight() {
        outputView.printAskHeight();
        while (true) {
            try {
                int height = inputView.readInt();
                if (height < 0) {
                    throw new IllegalArgumentException("높이는 양수여야 합니다.");
                }
                return height;
            } catch (InputMismatchException | IllegalArgumentException e) {
                outputView.printException(e);
                outputView.printRetryInputMessage();
            }
        }
    }

    public LadderGame startLadderGame(int height, Players players, Results results) {
        Ladder ladder = new Ladder(height, players.size(), new Random());
        LadderGame game = new LadderGame(ladder, players, results);
        outputView.printLadderResultTitle();
        outputView.printLadder(ladder, players.getPlayers(), results.getResults());
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
