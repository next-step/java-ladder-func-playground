package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Players {
    private final List<PlayerName> players;

    public Players(List<PlayerName> players) {
        validateDuplicate(players);
        this.players = List.copyOf(players);
    }

    private void validateDuplicate(List<PlayerName> players) {
        Set<PlayerName> set = new HashSet<>(players);
        if (set.size() != players.size()) {
            throw new IllegalArgumentException("플레이어 이름은 중복될 수 없습니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public List<PlayerName> getPlayers() {
        return players;
    }
}
