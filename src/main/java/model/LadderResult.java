package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private static final String NO_RESULT = "결과 없음";
    private final Map<String, String> results;
    private final Ladder ladder;

    public LadderResult(Ladder ladder) {
        this.ladder = ladder;
        this.results = new HashMap<>();
    }

    public void calculateResults(List<String> playerNames, Prizes prizes) {
        List<Line> lines = ladder.getLines();
        List<String> prizeValues = prizes.getPrize();

        for (String playerName : playerNames) {
            int playerIndex = playerNames.indexOf(playerName);
            for (Line line : lines) {
                playerIndex = getNewIndexMove(playerIndex, line.getPointGroups());
            }
            results.put(playerName, prizeValues.get(playerIndex));
        }
    }

    private int getNewIndexMove(int currentIndex, List<Point> points) {
        if (canMoveLeft(currentIndex, points)) {
            return currentIndex - 1;
        }
        if (canMoveRight(currentIndex, points)) {
            return currentIndex + 1;
        }
        return currentIndex;
    }

    private boolean canMoveLeft(int currentIndex, List<Point> points) {
        return currentIndex > 0 && points.get(currentIndex - 1) == Point.HAS_POINT;
    }

    private boolean canMoveRight(int currentIndex, List<Point> points) {
        return currentIndex < points.size() && points.get(currentIndex) == Point.HAS_POINT;
    }

    public String getResultForPlayer(String name) {
        return results.getOrDefault(name, NO_RESULT);
    }

    public Map<String, String> getValue() {
        return Collections.unmodifiableMap(results);
    }
}
