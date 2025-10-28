package controller;

import model.Ladder;
import model.LadderSize;
import model.Line;
import model.LadderFactory;
import model.LadderGame;
import model.BuildLine;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LadderController {
    private final LadderFactory factory = new LadderFactory();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    public static final int WIDTH = 4;

    public void run() {
        int height = inputView.heightSize();

        LadderSize size = new LadderSize(WIDTH,height);
        Ladder ladder = factory.create(size);

        List<String> lines = new ArrayList<>();
        for (Line line : ladder.lines()) {
            lines.add(BuildLine.build(line));
        }

        outputView.print(lines);
        ladderGame(ladder);
    }

    public void ladderGame(Ladder ladder) {
        LadderGame game = new LadderGame(ladder);
        Map<Integer, Integer> results = game.playAll();

        outputView.printResults(results);
    }
}
