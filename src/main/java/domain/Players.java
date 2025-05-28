package domain;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    private void validate(List<Player> players) {
        if (players == null || players.isEmpty()) {
            throw new IllegalArgumentException("플레이어 목록은 비어 있을 수 없습니다.");
        }
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public int size() {
        return players.size();
    }

    public Player get(int index) {
        return players.get(index);
    }
}
