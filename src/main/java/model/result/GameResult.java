package model.result;

import model.participant.Player;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private final Map<Player, Prize> results;

    public GameResult() {
        this.results = new LinkedHashMap<>();
    }

    public void addResult(Player player, Prize prize) {
        results.put(player, prize);
    }

    public Prize getDestination(String playerName) {
        String nameKey = playerName.trim();

        return results.keySet()
                .stream()
                .filter(playerKey -> playerKey.getName().equals(nameKey))
                .findFirst()
                .map(results::get)
                .orElse(null);
    }
}
