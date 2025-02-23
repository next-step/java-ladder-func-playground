package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final List<Player> players;
    private final List<Prize> prizes;
    private final Ladder ladder;
    private final Map<String, String> results;

    public LadderGame(List<Player> players, List<Prize> prizes, int height) {
        validatePlayersAndPrizes(players, prizes);
        this.players = players;
        this.prizes = prizes;
        this.ladder = new Ladder(players.size(), height);
        this.results = calculateResult();
    }

    private Map<String, String> calculateResult() {
        int width = players.size();
        Map<String, String> resultMap = new LinkedHashMap<>();
        for (int index = 0; index < width; index++) {
            int endIndex = movePlayer(index);
            Player player = players.get(index);
            Prize prize = prizes.get(endIndex);
            resultMap.put(player.getName(), prize.getPrize());
        }
        return resultMap;
    }

    private void validatePlayersAndPrizes(List<Player> players, List<Prize> prizes) {
        if (players.size() != prizes.size()) {
            throw new IllegalArgumentException("참여자 수와 결과 수가 일치하지 않습니다.");
        }
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
        return players;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Map<String, String> getResults() {
        return results;
    }
}
