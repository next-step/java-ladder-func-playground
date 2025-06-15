package controller;

import static constants.ReservedWord.FINISH_KEYWORD;

import domain.dto.RequestLadderGame;
import domain.dto.ResponseLadder;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.ladder.result.LadderResultBoard;
import domain.player.Players;
import domain.runningResult.Results;
import java.util.function.Function;
import java.util.function.Supplier;
import strategy.LineGenerator;
import strategy.PointGenerator;
import strategy.RandomLineGenerator;
import strategy.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final String NOT_FOUND_PLAYER_RETRY_MESSAGE = "존재하지 않는 플레이어입니다. 다시 입력해주세요.";

    public void play() {
        RequestLadderGame request = inputLadderSettings();
        Players players = request.toPlayers();
        Height height = request.toHeight();
        Results results = request.toResults(players.size());

        Ladder ladder = drawLadder(players, height);
        LadderResultBoard resultBoard = LadderResultBoard.of(players, ladder, results);

        showGameScreen(players, ladder, results);
        showPlayerResult(resultBoard);
    }

    private RequestLadderGame inputLadderSettings() {
        String names = InputView.inputPlayerNames();
        String results = InputView.inputRunningResult();
        String height = InputView.inputLadderHeight();
        return new RequestLadderGame(names, results, height);
    }

    private Ladder drawLadder(final Players players, final Height height) {
        LineGenerator generator = createLineGenerator();
        LadderFactory factory = new LadderFactory();
        return factory.draw(players, height, generator);
    }

    private LineGenerator createLineGenerator() {
        PointGenerator pointGenerator = new RandomPointGenerator();
        return new RandomLineGenerator(pointGenerator);
    }

    private void showGameScreen(final Players players, final Ladder ladder, final Results results) {
        OutputView.printLadderResultTitle();
        OutputView.printPlayerNames(players);
        OutputView.drawLadder(ResponseLadder.from(ladder));
        OutputView.printResults(results);
    }

    private void showPlayerResult(final LadderResultBoard board) {
        repeatUntilDone(
                InputView::inputTargetPlayerName,
                name -> {
                    if (name.equals(FINISH_KEYWORD)) {
                        OutputView.printAllLadderResult(board);
                        return true;
                    }

                    if (board.findResultOf(name).isEmpty()) {
                        System.out.println();
                        System.out.println(NOT_FOUND_PLAYER_RETRY_MESSAGE);
                        return false;
                    }

                    OutputView.printSingleLadderResult(board, name);
                    return false;
                }
        );
    }

    private void repeatUntilDone(final Supplier<String> inputSupplier, final Function<String, Boolean> handler) {
        boolean done = false;
        while (!done) {
            String input = inputSupplier.get();
            done = handler.apply(input);
        }
    }
}
