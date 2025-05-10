package domain.user;

import domain.prize.PrizeName;
import java.util.Map;

public class PlayerResults {

    private final Map<PlayerName, PrizeName> results;

    public PlayerResults(Map<PlayerName, PrizeName> results) {
        this.results = Map.copyOf(results);
    }

    public PrizeName get(PlayerName name) {
        if (!results.containsKey(name)) {
            throw new IllegalArgumentException("해당 플레이어의 결과가 없습니다.");
        }
        return results.get(name);
    }

    public Map<PlayerName, PrizeName> getAll() {
        return results;
    }
}
