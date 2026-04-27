package domain;

import java.util.List;

public class Players {
    private final List<Player> players;

    public Players(List<String> players) {
        this.players = players.stream()
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
}
