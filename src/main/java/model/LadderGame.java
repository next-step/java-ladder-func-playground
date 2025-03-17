package model;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGame {
    private final Ladder ladder;
    private final LadderResult ladderResult;

    public LadderGame(Ladder ladder, LadderResult ladderResult) {
        this.ladder = ladder;
        this.ladderResult = ladderResult;
    }

    public static LadderGame createGame(Players players, Height maxHeight,
                                        PointGenerator pointGenerator,
                                        Prizes prizes) {

        Ladder ladder = new Ladder(generateLines(players.size(), maxHeight.getValue(), pointGenerator));
        LadderResult ladderResult = new LadderResult(ladder);
        ladderResult.calculateResults(players.getPlayers(), prizes);
        return new LadderGame(ladder, ladderResult);
    }

    private static List<Line> generateLines(int playerCount, int maxHeight, PointGenerator pointGenerator) {
        return IntStream.range(0, maxHeight)
                .mapToObj(i -> new Line(pointGenerator.createLinePoints(new Size(playerCount))))
                .toList();
    }

    public List<Point> getLadderPoints() {
        return ladder.getPointsFromLines();
    }

    public String getResultForPlayer(String name) {
        return ladderResult.getResultForPlayer(name);
    }

    public Map<String, String> getAllResultForPlayers() {
        return ladderResult.getValue();
    }

    public boolean hasResultForPlayer(String name) {
        return ladderResult.getValue().containsKey(name);
    }
}
