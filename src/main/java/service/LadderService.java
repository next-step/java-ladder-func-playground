package service;

import domain.Ladder;
import dto.response.GetLadderResultResponse;
import dto.response.GetLadderShapeResponse;

public class LadderService {

    private Ladder ladder;

    public LadderService() {
    }

    public void createLadder(int height, int width) {
        this.ladder = new Ladder(height, width);
    }

    public GetLadderShapeResponse getLadderShape() {
        return GetLadderShapeResponse.from(ladder);
    }

    public GetLadderResultResponse getLadderAllResult() {
        return GetLadderResultResponse.from(ladder.getLadderAllResult());
    }
}
