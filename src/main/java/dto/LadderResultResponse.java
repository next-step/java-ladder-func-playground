package dto;

import domain.LadderResult;

import java.util.LinkedHashMap;
import java.util.Map;

public record LadderResultResponse(Map<String, String> results) {
    public static LadderResultResponse from(LadderResult ladderResult) {
        Map<String, String> allResults = new LinkedHashMap<>();
        ladderResult.getAllResults()
                .forEach(((player, result) -> allResults.put(player.getName(), result)));
        return new LadderResultResponse(allResults);
    }
}
