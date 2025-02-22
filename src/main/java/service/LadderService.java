package service;

import domain.Ladder;
import dto.response.GetLadderResponse;

public class LadderService {

    private Ladder ladder;

    public LadderService() {
    }

    public void createLadder(int height, int width) {
        this.ladder = new Ladder(height, width);
    }

    public GetLadderResponse getLadder() {
        return GetLadderResponse.from(ladder);
    }
}
