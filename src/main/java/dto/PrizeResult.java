package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record PrizeResult(String playerName, String prize) {

    public static List<PrizeResult> from(Map<String, String> ladderResult) {
        return ladderResult.entrySet().stream()
                .map(PrizeResult::from)
                .toList();
    }

    private static PrizeResult from(Map.Entry<String, String> entry) {
        return new PrizeResult(entry.getKey(), entry.getValue());
    }
}
