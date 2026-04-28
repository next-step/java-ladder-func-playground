package domain;

import constant.ErrorMessage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
    private final Map<Player, String> results;

    public LadderResult(Players players, Prizes prizes, List<Integer> endIndex) {
        this.results = calculateResult(players, prizes.getPrizeNames(), endIndex);
    }

    public Map<String, String> getAllResults() {
        Map<String, String> allResults = new LinkedHashMap<>();
        results.forEach(((player, string) -> allResults.put(player.getName(), string)));
        return allResults;
    }

    public String getResultByPlayerName(Player player) {
        return results.entrySet().stream()
                .filter(
                        entry -> entry.getKey().getName().equals(player.getName())
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
