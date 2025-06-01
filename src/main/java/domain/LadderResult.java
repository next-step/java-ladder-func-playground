package domain;

import java.util.Collections;
import java.util.Map;

public class LadderResult {
    private final Map<Player, Reward> resultMap;

    public LadderResult(Map<Player, Reward> resultMap) {
        this.resultMap = resultMap;
    }

    public Map<Player, Reward> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }

    public Reward findRewardByPlayerName(String playerName) {
        return resultMap.entrySet().stream()
                .filter(entry -> entry.getKey().name().equals(playerName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 참가자가 존재하지 않습니다: " + playerName));
    }
}
