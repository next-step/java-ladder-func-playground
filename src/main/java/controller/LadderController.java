package controller;

import domain.dto.RequestLadderGame;
import domain.dto.ResponseLadder;
import domain.dto.ResponseLadderResult;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.player.Players;
import strategy.LineGenerator;
import strategy.PointGenerator;
import strategy.RandomLineGenerator;
import strategy.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    public void play() {
        RequestLadderGame requestLadderGame = inputLadderSettings();
        Players players = requestLadderGame.toPlayers();
        Height height = requestLadderGame.toHeight();

        LineGenerator lineGenerator = createLineGenerator();
        LadderFactory factory = new LadderFactory();
        Ladder ladder = factory.draw(players, height, lineGenerator);

        drawLadder(ladder, players);
    }

    private RequestLadderGame inputLadderSettings() {
        String playerNames = InputView.inputPlayerNames();
        String runningResult = InputView.inputRunningResult();
        String height = InputView.inputLadderHeight();
        return new RequestLadderGame(playerNames, runningResult, height);
    }

    private LineGenerator createLineGenerator() {
        PointGenerator pointGenerator = new RandomPointGenerator();
        return new RandomLineGenerator(pointGenerator);
    }

    private void drawLadder(final Ladder ladder, final Players players) {
        OutputView.printLadderResultTitle();

        ResponseLadder responseLadder = ResponseLadder.from(ladder);
        OutputView.drawLadder(responseLadder);

        ResponseLadderResult responseResult = ResponseLadderResult.of(ladder, players);
        OutputView.printLadderResult(responseResult);
    }
}
