package domain;

import java.util.Map;

public class LadderResult {
    private final Map<String, String> mappedResult;

    public LadderResult(Map<String, String> mappedResult) {
        validateLadderResult(mappedResult);
        this.mappedResult = mappedResult;
    }

    public Map<String, String> getMappedResult() {
        return mappedResult;
    }

    private void validateLadderResult(Map<String, String> result) {
        for (Map.Entry<String, String> entry : result.entrySet()) {
            String player = entry.getKey();
            String prize = entry.getValue();
            if (player == null || player.isBlank()) {
                throw new IllegalArgumentException("플레이어 이름이 비어 있습니다.");
            }
            if (prize == null || prize.isBlank()) {
                throw new IllegalArgumentException("결과가 비어 있습니다.");
            }
        }
    }

}
