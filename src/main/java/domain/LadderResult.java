package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    public static final String ERROR_NO_NAME = "존재하지 않는 이름입니다.";
    public static final String ERROR_RESULTS_SIZE = "결과의 수는 참가자의 수와 같아야합니다.";
    private final Map<String, String> resultMap = new LinkedHashMap<>();

    public LadderResult(Ladder ladder, Players players, Rewards rewards) {
        validate(players, rewards);
        for (int i = 0; i < players.getCount(); i++) {
            String playerName = players.getName(i);
            int finalPosition = ladder.move(i);
            String result = rewards.getReward(finalPosition);
            resultMap.put(playerName, result);
        }
    }

    private void validate(Players players, Rewards rewards) {
        if (rewards.getCount()!= players.getCount()) {
            throw new IllegalArgumentException(ERROR_RESULTS_SIZE);
        }
    }

    public String getResult(String name) {
        if (!resultMap.containsKey(name)) {
            throw new IllegalArgumentException(ERROR_NO_NAME);
        }
        return resultMap.get(name);
    }

    public Map<String, String> getResults() {
        return new LinkedHashMap<>(resultMap);
    }
}
