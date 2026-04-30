package domain;

import constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {
    private final List<Player> players;

    public Players(List<String> playerNames) {
        validateNameDuplicate(playerNames);
        this.players = playerNames.stream()
                .map(Player::new)
                .toList();
    }

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public List<String> getPlayersName() {
        return List.copyOf(
                players.stream().map(Player::getName).toList()
        );
    }

    public int getPlayerCount() {
        return players.size();
    }

    public boolean containsPlayer(Player targetPlayer) {
        return players.stream()
                .anyMatch(player -> player.equals(targetPlayer));
    }

    private void validateNameDuplicate(List<String> players) {
        Set<String> uniquePlayers = new HashSet<>(players);

        if (uniquePlayers.size() != players.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_PLAYER_NAME.getMessage());
        }
    }
}
