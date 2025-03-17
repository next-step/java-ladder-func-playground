package model;

import java.util.List;

public class Players {

    private static final int MITMUM_PLAYER_LENGTH = 2;
    private final List<Player> players;

    public Players(List<String> players) {
        validatePlayers(players);
        this.players = generatePlayers(players);
    }

    public int size() {
        return players.size();
    }

    public List<String> getPlayers() {
        return players.stream()
                .map(Player::getValue)
                .toList();
    }

    private List<Player> generatePlayers(List<String> players) {
        return players.stream()
                .map(Player::new)
                .toList();
    }

    private void validatePlayers(List<String> players) {
        if (players.size() < MITMUM_PLAYER_LENGTH) {
            throw new IllegalArgumentException("참가자는 2명 이상이여야 합니다.");
        }
    }
}
