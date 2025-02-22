package dto.response;

import domain.Ladder;
import domain.Line;

import java.util.List;

public record GetLadderShapeResponse(
        List<List<Boolean>> ladders
) {

    public static GetLadderShapeResponse from(Ladder ladder) {
        return new GetLadderShapeResponse(ladder.getLines().stream()
                .map(Line::getPoints)
                .toList());
    }
}
