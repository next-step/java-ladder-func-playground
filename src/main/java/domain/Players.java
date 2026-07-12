package domain;

import java.util.List;

public class Players {

    private static final int MIN_PLAYERS_COUNT = 1;

    private final List<Player> players;

    public Players(List<Player> players) {
        validateCount(players);
        this.players = players;
    }

    private void validateCount(List<Player> players) {
        if (players.isEmpty()) {
            throw new IllegalArgumentException("참여 인원은 최소 " + MIN_PLAYERS_COUNT + "명 이상이어야 합니다.");
        }
    }

    public int count() {
        return players.size();
    }

    public List<Player> extractPlayers() {
        return List.copyOf(players);
    }

    public List<String> extractNames() {
        return players.stream()
                .map(Player::getName)
                .toList();
    }
}
