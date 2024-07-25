package controller;

import java.util.List;
import java.util.Random;

import model.Ladder;
import model.Player;
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
        int width = inputView.getWidth();
        int height = inputView.getHeight();

        Ladder ladder = Ladder.of(width, height, random);

        Players players = Players.from(width);
        players.move(ladder);

        Result result = Result.from(players);

        outputView.outLadder(ladder);
        outputView.outResult(result);
    }
}
