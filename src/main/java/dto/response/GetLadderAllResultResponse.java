package dto.response;

import domain.LadderResult;

import java.util.Map;
import java.util.stream.Collectors;

public record GetLadderAllResultResponse(
        Map<String, String> results
) {

    public static GetLadderAllResultResponse from(Map<String, LadderResult> results) {
        return new GetLadderAllResultResponse(results.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getResult()
                )));
    }
}
