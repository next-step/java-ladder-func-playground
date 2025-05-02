package Domain;

import LadderDomain.Ladder;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerResults {

    private final Map<PlayerName, PrizeName> results;

    public PlayerResults(Map<PlayerName, PrizeName> results) {
        this.results = Map.copyOf(results);
    }

    public static PlayerResults of(PlayerNames playerNames, Ladder ladder, PrizeNames prizeNames) {
        Map<PlayerName, PrizeName> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < playerNames.size(); i++) {
            int end = ladder.move(i);

            if (end >= prizeNames.getAll().size()) {
                throw new IllegalStateException("사다리 결과 인덱스가 결과 수보다 큽니다: index=" + end);
            }

            resultMap.put(playerNames.get(i), prizeNames.get(end));
        }
        return new PlayerResults(resultMap);
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
