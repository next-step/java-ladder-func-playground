package controller;

import model.Ladder;
import model.LadderSize;
import model.Line;
import model.LadderFactory;
import model.BuildLine;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderController {
    private final LadderFactory factory = new LadderFactory();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        int width = inputView.widthSize();
        int height = inputView.heightSize();

        LadderSize size = new LadderSize(width, height);
        Ladder ladder = factory.create(size);

        List<String> lines = new ArrayList<>();
        for (Line line : ladder.lines()) {
            lines.add(BuildLine.build(line));
        }

        outputView.print(lines);
    }
}
