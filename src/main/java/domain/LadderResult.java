package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {

    private final Ladder ladder;
    private final Map<Integer, Integer> results;

    public LadderResult(Ladder ladder) {
        this.ladder = ladder;
        this.results = calculateResult();
    }

    private Map<Integer, Integer> calculateResult() {
        int width = ladder.getLadderSize().getWidth();
        Map<Integer, Integer> results = new LinkedHashMap<>();
        for (int index = 0; index < width; index++) {
            results.put(index, movePlayer(index));
        }
        return results;
    }

    private int movePlayer(int startIndex) {
        int currentIndex = startIndex;
        for (Line line : ladder.getLines()) {
            currentIndex = nextPosition(line, currentIndex);
        }
        return currentIndex;
    }

    private int nextPosition(Line line, int currentIndex) {
        if (canMoveLeft(line, currentIndex)) {
            return currentIndex - 1;
        }
        if (canMoveRight(line, currentIndex)) {
            return currentIndex + 1;
        }
        return currentIndex;
    }

    private boolean canMoveLeft(Line line, int currentIndex) {
        if (currentIndex <= 0) {
            return false;
        }
        return line.getPoints().get(currentIndex - 1);
    }

    private boolean canMoveRight(Line line, int currentIndex) {
        if (currentIndex >= line.getPoints().size()) {
            return false;
        }
        return line.getPoints().get(currentIndex);
    }

    public Map<Integer, Integer> getResults() {
        return results;
    }
}
