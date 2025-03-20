package controller;

import model.Height;
import model.Players;
import model.PointGenerator;
import model.Prizes;
import model.Ladder;
import model.LadderResult;
import model.RandomValueGenerator;
import model.Point;
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
        Players players = new Players(inputView.inputNames());
        Prizes prizes = Prizes.createPrizes(inputView.inputResult(), players);
        Height height = new Height(inputView.getMaxLadderHeight());
        PointGenerator pointGenerator = new PointGenerator(new RandomValueGenerator());

        Ladder ladder = Ladder.createLadder(players.size(), height.getValue(), pointGenerator);
        LadderResult ladderResult = calculateLadderResult(ladder, players.getPlayers(), prizes);

        printLadder(ladder, players, prizes);
        printResult(ladderResult);
    }

    private LadderResult calculateLadderResult(Ladder ladder, List<String> players, Prizes prizes) {
        LadderResult ladderResult = new LadderResult(ladder);
        ladderResult.calculateResults(players, prizes);
        return ladderResult;
    }

    private void printLadder(Ladder ladder, Players players, Prizes prizes) {
        List<Boolean> points = formatLadderPoints(ladder.getPointsFromLines());
        List<List<Boolean>> ladderLines = processLadderLines(points, players.size());
        resultView.printLadder(ladderLines, players.getPlayers(), prizes.getPrize());
    }

    private void printResult(LadderResult ladderResult) {
        while (true) {
            String targetPlayerName = inputView.getTargetPlayerName();

            if (targetPlayerName.equals(ALL_PLAYERS)) {
                resultView.printAllResults(ladderResult.getValue());
                break;
            }
            if (ladderResult.getValue().containsKey(targetPlayerName)) {
                resultView.printSingleResult(ladderResult.getResultForPlayer(targetPlayerName));
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
