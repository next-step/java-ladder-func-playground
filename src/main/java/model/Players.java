package model;

import exception.ExceptionMessage;

import java.util.List;

public class Players {

    private static final int MIN_PLAYER_LENGTH = 2;
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
        if (players.size() < MIN_PLAYER_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.MIN_PLAYERS_REQUIRED.getMessage());
        }
    }
}
