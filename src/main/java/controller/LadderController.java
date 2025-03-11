package controller;

import domain.Ladder;
import dto.LadderDto;

public class LadderController {
    private final Ladder ladder;

    public LadderController(int width, int height) {
        this.ladder = Ladder.of(width, height);
    }

    public LadderDto getLadderData() {
        return LadderDto.from(ladder);
    }
}
