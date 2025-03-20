package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    private static final String NO_RESULT = "결과 없음";
    private final Map<String, String> results;
    private final Ladder ladder;

    public LadderResult(Ladder ladder) {
        this.ladder = ladder;
        this.results = new HashMap<>();
    }

    public void calculateResults(List<String> playerNames, Prizes prizes) {
        List<String> prizeValues = prizes.getPrize();

        for (String playerName : playerNames) {
            int playerIndex = playerNames.indexOf(playerName);
            playerIndex = ladder.move(playerIndex);
            results.put(playerName, prizeValues.get(playerIndex));
        }
    }

    public String getResultForPlayer(String name) {
        return results.getOrDefault(name, NO_RESULT);
    }

    public Map<String, String> getValue() {
        return Collections.unmodifiableMap(results);
    }
}
