package domain;

import java.util.Collections;
import java.util.Map;

public class LadderResult {

    private final Map<String, String> ladderResult;

    private LadderResult(Map<String, String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public static LadderResult create(Map<String, String> rawLadderResult) {
        validate(rawLadderResult);
        return new LadderResult(rawLadderResult);
    }

    public String prizeOf(String targetName) {
        if (!ladderResult.containsKey(targetName)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
        return ladderResult.get(targetName);
    }

    public Map<String, String> all() {
        return Collections.unmodifiableMap(ladderResult);
    }

    private static void validate(Map<String, String> rawLadderResult) {
        if (rawLadderResult == null) {
            throw new IllegalArgumentException("결과 값을 넘겨야 합니다.");
        }
        if (rawLadderResult.containsKey(null) || rawLadderResult.containsValue(null)) {
            throw new IllegalArgumentException("결과에는 null 키나 값이 없어야 합니다.");
        }
    }
}
