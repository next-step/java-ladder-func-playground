package dto.response;

import domain.ladder.LadderResult;

public record GetLadderResultResponse(
        String result
) {

    public static GetLadderResultResponse from(LadderResult result) {
        return new GetLadderResultResponse(result.getResult());
    }
}
