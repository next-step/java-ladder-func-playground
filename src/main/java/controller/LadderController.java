package controller;

import domain.Ladder;
import domain.Line;
import domain.LineIndexGenerator;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final LineIndexGenerator lineIndexGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(LineIndexGenerator lineIndexGenerator, InputView inputView,
            OutputView outputView) {
        this.lineIndexGenerator = lineIndexGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int width = readLadderWidth();
        int height = readLadderHeight();

        Ladder ladder = getLadder(height, width);
        outputView.printLadderGameResult(ladder, width);
    }

    private int readLadderHeight() {
        outputView.printLadderHeight();
        return inputView.readLadderValue();
    }

    private int readLadderWidth() {
        outputView.printLadderWidth();
        return inputView.readLadderValue();
    }

    private Ladder getLadder(int height, int width) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            List<Integer> randomIndexes = lineIndexGenerator.generate(width);
            Line line = Line.fromRandomIndex(randomIndexes, width - 1);
            lines.add(line);
        }

        return new Ladder(lines);
    }
}
