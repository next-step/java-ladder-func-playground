package controller;

import model.*;
import view.InputView;
import view.ResultView;
import java.util.ArrayList;
import java.util.List;
import static model.Point.HAS_POINT;

public class LadderController {

    private static final int CHUNK_SIZE = 3;
    private final ResultView resultView = new ResultView();
    private final InputView inputView = new InputView();

    public void startLadder() {
        Players player = new Players(inputView.inputNames());
        Prizes prizes = Prizes.form(inputView.inputResult(), player);
        Height height = new Height(inputView.getMaxLadderHeight());
        PointGenerator pointGenerator = new PointGenerator(new RandomValueGenerator());
        LadderGame ladderGame = LadderGame.createGame(player, height, pointGenerator, prizes);

        List<Boolean> points = formatLadderPoints(ladderGame.getLadderPoints());
        List<List<Boolean>> ladderLines = processLadderLines(points);
        resultView.printLadder(ladderLines, player.getPlayers(), prizes.getPrize());
        printResult(ladderGame);
    }

    private void printResult(LadderGame ladderGame) {
        while (true) {
            String targetPlayerName = inputView.getTargetPlayerName();

            if (targetPlayerName.equals("all")) {
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

    private List<List<Boolean>> processLadderLines(List<Boolean> ladderPoints) {
        List<List<Boolean>> chunks = new ArrayList<>();
        for (int i = 0; i < ladderPoints.size(); i += CHUNK_SIZE) {
            chunks.add(getLadderSegment(ladderPoints, i));
        }
        return chunks;
    }

    private List<Boolean> getLadderSegment(List<Boolean> ladderPoints, int startIndex) {
        return ladderPoints.subList(startIndex, Math.min(startIndex + CHUNK_SIZE, ladderPoints.size()));
    }
}
