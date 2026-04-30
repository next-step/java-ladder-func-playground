package domain;

import constant.ErrorMessage;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private final Map<Player, String> results;

    public LadderResult(Players players, Prizes prizes, List<Integer> endIndex) {
        this.results = calculateResult(players, prizes.getPrizeNames(), endIndex);
    }

    public Map<Player, String> getAllResults() {
        return Collections.unmodifiableMap(results);
    }

    public String getResultByPlayer(Player player) {
        return results.entrySet().stream()
                .filter(
                        entry -> entry.getKey().equals(player)
                )
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.PLAYER_NOT_FOUND.getMessage()));
    }

    private Map<Player, String> calculateResult(Players players, List<String> prizesName, List<Integer> endIndex) {
        Map<Player, String> results = new LinkedHashMap<>();
        List<Player> playerList = players.getPlayers();

        for (int i = 0; i < playerList.size(); i++) {
            results.put(playerList.get(i), prizesName.get(endIndex.get(i)));
        }

        return results;
    }
}
