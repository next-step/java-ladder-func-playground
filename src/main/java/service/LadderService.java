package service;

import domain.Ladder;
import dto.response.GetLadderResponse;

public class LadderService {

    private Ladder ladder;

    public LadderService() {
    }

    public void createLadder() {
        this.ladder = new Ladder(4, 4);
    }

    public GetLadderResponse getLadder() {
        return GetLadderResponse.from(ladder);
    }
}
