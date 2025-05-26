package domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderResult {
    public static final String ERROR_NO_NAME = "존재하지 않는 이름입니다.";
    private final Map<String, String> resultMap = new LinkedHashMap<>();

    public LadderResult(Ladder ladder, Players players, Results results) {
        for (int i = 0; i < players.getCount(); i++) {
            String playerName = players.getName(i);
            int finalPosition = ladder.move(i);
            String result = results.getResult(finalPosition);
            resultMap.put(playerName, result);
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
