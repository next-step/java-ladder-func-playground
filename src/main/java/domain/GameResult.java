package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
    private final List<Player> players;

    public GameResult(List<Player> players) {
        this.players = players;
    }

    public static GameResult of(Players players, Rewards rewards, LadderResult ladderResult) {
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            playerList.add(createPlayer(i, players, rewards, ladderResult));
        }
        return new GameResult(playerList);
    }

    private static Player createPlayer(int index, Players players, Rewards rewards, LadderResult result) {
        Position start = new Position(index);
        Position end = result.getEndPosition(start);
        return new Player(players.getName(index), rewards.getReward(end.getValue()));
    }

    public Player findByName(String targetName) {
        return players.stream()
                .filter(player -> player.hasName(targetName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사람입니다."));
    }

    public List<Player> getAll() {
        return Collections.unmodifiableList(players);
    }
}
