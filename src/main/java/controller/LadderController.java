package controller;

import domain.Ladder;
import domain.dto.RequestLadder;
import strategy.LineGenerator;
import strategy.PointGenerator;
import strategy.RandomLineGenerator;
import strategy.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void start() {
        RequestLadder requestLadder = readLadderInput();

        LineGenerator lineGenerator = buildLineGenerator();
        Ladder ladder = Ladder.create(requestLadder.width(), requestLadder.height(), lineGenerator);

        paintLadder(ladder);
    }

    private RequestLadder readLadderInput() {
        int width = InputView.inputLadderWidth();
        int height = InputView.inputLadderHeight();
        return new RequestLadder(width, height);
    }

    private LineGenerator buildLineGenerator() {
        PointGenerator pointGenerator = new RandomPointGenerator();
        return new RandomLineGenerator(pointGenerator);
    }

    private void paintLadder(final Ladder ladder) {
        OutputView.printLadderResultTitle();
        OutputView.paintLadder(ladder);
    }
}
