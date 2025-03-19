package controller;

import model.*;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static model.Point.HAS_POINT;

public class LadderController {

    private static final String ALL_PLAYERS = "all";
    private final ResultView resultView = new ResultView();
    private final InputView inputView = new InputView();

    public void startLadder() {
        Players player = new Players(inputView.inputNames());
        Prizes prizes = Prizes.from(inputView.inputResult(), player);
        Height height = new Height(inputView.getMaxLadderHeight());
        PointGenerator pointGenerator = new PointGenerator(new RandomValueGenerator());
        LadderGame ladderGame = LadderGame.createGame(player, height, pointGenerator, prizes);

        List<Boolean> points = formatLadderPoints(ladderGame.getLadderPoints());
        List<List<Boolean>> ladderLines = processLadderLines(points, player.size());
        resultView.printLadder(ladderLines, player.getPlayers(), prizes.getPrize());
        printResult(ladderGame);
    }

    private void printResult(LadderGame ladderGame) {
        while (true) {
            String targetPlayerName = inputView.getTargetPlayerName();

            if (targetPlayerName.equals(ALL_PLAYERS)) {
                resultView.printAllResults(ladderGame.getAllResultForPlayers());
                break;
            }
            if (ladderGame.hasResultForPlayer(targetPlayerName)) {
                resultView.printSingleResult(ladderGame.getResultForPlayer(targetPlayerName));
            }
        }
    }

    private List<Boolean> formatLadderPoints(List<Point> ladderPoints) {
        List<Boolean> formattedLadder = new ArrayList<>();
        for (Point point : ladderPoints) {
            formattedLadder.add(point == HAS_POINT);
        }
        return formattedLadder;
    }

    private List<List<Boolean>> processLadderLines(List<Boolean> ladderPoints, int numPlayers) {
        int lineCount = numPlayers - 1;
        List<List<Boolean>> chunks = new ArrayList<>();
        for (int i = 0; i < ladderPoints.size(); i += lineCount) {
            chunks.add(getLadderSegment(ladderPoints, i, lineCount));
        }
        return chunks;
    }

    private List<Boolean> getLadderSegment(List<Boolean> ladderPoints, int startIndex, int lineCount) {
        return ladderPoints.subList(startIndex, Math.min(startIndex + lineCount, ladderPoints.size()));
    }
}
