package dto.response;

import domain.LadderResult;

public record GetLadderResultResponse(
        String result
) {

    public static GetLadderResultResponse from(LadderResult result) {
        return new GetLadderResultResponse(result.getResult());
    }
}
