package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final LadderGameData gameData;
    private final Ladder ladder;

    public LadderGame(Players players, Prizes prizes, int ladderHeight) {
        this.gameData = new LadderGameData(players, prizes);
        this.ladder = new Ladder(players.getNames().size(), ladderHeight);
    }

    public Map<String, String> calculateResult() {
        int ladderWidth = ladder.getWidth();
        Map<String, String> resultMap = new LinkedHashMap<>();
        for (int startIndex = 0; startIndex < ladderWidth; startIndex++) {
            int endIndex = getFinalPosition(startIndex);
            String playerName = gameData.getPlayers().getNames().get(startIndex);
            String prizeName = gameData.getPrizes().getNames().get(endIndex);
            resultMap.put(playerName, prizeName);
        }
        return resultMap;
    }

    private int getFinalPosition(int startIndex) {
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

    public LadderGameData getGameData() {
        return gameData;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
