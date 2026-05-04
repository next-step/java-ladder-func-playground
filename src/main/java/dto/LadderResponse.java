package dto;

import domain.Ladder;

import java.util.List;

public record LadderResponse(List<LineResponse> ladder) {
    public static LadderResponse from(Ladder ladder) {
        List<LineResponse> lineResponses = ladder.getBridges().stream()
                .map(LineResponse::from)
                .toList();
        return new LadderResponse(lineResponses);
    }
}
