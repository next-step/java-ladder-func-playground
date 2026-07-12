package service.ladder;

import domain.ladder.Ladder;

public interface LadderService {

    void makeLadder(final int width, final int height);

    Ladder getLadder();
}
