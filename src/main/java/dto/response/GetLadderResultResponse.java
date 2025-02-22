package dto.response;

import java.util.Map;

public record GetLadderResultResponse(
        Map<Integer, Integer> result
) {

    public static GetLadderResultResponse from(Map<Integer, Integer> result) {
        return new GetLadderResultResponse(result);
    }
}
