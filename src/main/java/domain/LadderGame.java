package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final LadderGameData ladderGameData;
    private final Ladder ladder;

    public LadderGame(List<Player> players, List<Prize> prizes, int height) {
        this.ladderGameData = new LadderGameData(players, prizes);
        this.ladder = new Ladder(players.size(), height);
    }

    public Map<String, String> calculateResult() {
        int width = ladder.getWidth();
        Map<String, String> resultMap = new LinkedHashMap<>();
        for (int index = 0; index < width; index++) {
            int endIndex = movePlayer(index);
            Player player = getPlayers().get(index);
            Prize prize = getPrizes().get(endIndex);
            resultMap.put(player.getName(), prize.getPrize());
        }
        return resultMap;
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

    public List<Player> getPlayers() {
        return ladderGameData.getPlayers();
    }

    public List<Prize> getPrizes() {
        return ladderGameData.getPrizes();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
