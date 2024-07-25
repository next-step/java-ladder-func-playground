package controller;

import java.util.List;
import java.util.Random;

import model.Ladder;
import model.Players;
import model.Result;
import view.InputView;
import view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Random random;

    public Controller(InputView inputView, OutputView outputView, Random random) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.random = random;
    }

    public void start() {
        List<String> names = inputView.getNames();
        Players players = Players.from(names);

        List<String> choices = inputView.getChoices();

        int height = inputView.getHeight();

        Ladder ladder = Ladder.of(players.size(), height, random);

        players.move(ladder);

        Result result = Result.of(players, choices);

        outputView.outLadder(players, ladder, choices);
        outResult(result);
    }

    private void outResult(Result result) {
        String target = inputView.getName();

        if (target.equalsIgnoreCase("all")) {
            outputView.outAllResult(result);
        } else {
            outputView.outResult(target, result);
        }
    }
}
