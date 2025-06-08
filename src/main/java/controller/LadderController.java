package controller;

import domain.Height;
import domain.Width;
import domain.dto.RequestLadder;
import domain.dto.ResponseLadder;
import domain.dto.ResponseLadderResult;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import strategy.LineGenerator;
import strategy.PointGenerator;
import strategy.RandomLineGenerator;
import strategy.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void play() {
        RequestLadder requestLadder = inputLadderSettings();
        Width width = requestLadder.toWidth();
        Height height = requestLadder.toHeight();

        LineGenerator lineGenerator = createLineGenerator();
        LadderFactory factory = new LadderFactory();
        Ladder ladder = factory.draw(width, height, lineGenerator);

        drawLadder(ladder, width);
    }

    private RequestLadder inputLadderSettings() {
        String width = InputView.inputLadderWidth();
        String height = InputView.inputLadderHeight();
        return new RequestLadder(width, height);
    }

    private LineGenerator createLineGenerator() {
        PointGenerator pointGenerator = new RandomPointGenerator();
        return new RandomLineGenerator(pointGenerator);
    }

    private void drawLadder(final Ladder ladder, final Width width) {
        OutputView.printLadderResultTitle();

        ResponseLadder responseLadder = ResponseLadder.from(ladder);
        OutputView.drawLadder(responseLadder);

        ResponseLadderResult responseResult = ResponseLadderResult.of(ladder, width);
        OutputView.printLadderResult(responseResult);
    }
}
