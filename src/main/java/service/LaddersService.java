package service;

import domain.CountOfLadders;
import domain.Height;
import domain.Ladder;
import domain.Ladders;
import domain.RungsBuilder;
import java.util.ArrayList;
import java.util.List;

public class LaddersService {

    private final RungsBuilder rungsBuilder;

    public LaddersService(RungsBuilder rungsBuilder) {
        this.rungsBuilder = rungsBuilder;
    }

    public Ladders createLadders(CountOfLadders countOfLadders, Height height) {
        final List<Ladder> ladderCollection = createLadderCollection(countOfLadders, height);
        return Ladders.from(ladderCollection);
    }

    private List<Ladder> createLadderCollection(CountOfLadders countOfLadders, Height height) {
        final List<Ladder> ladderCollection = new ArrayList<>();

        for (int index = 0; index < countOfLadders.value(); index++) {
            final Ladder prevLadder = getPrevLadder(ladderCollection, index, height);

            final Ladder nowLadder = createNowLadder(prevLadder);
            ladderCollection.add(nowLadder);
        }
        return ladderCollection;
    }

    private Ladder getPrevLadder(List<Ladder> ladderCollection, int index, Height height) {
        if (index == 0) {
            return createTemporaryLadder(height);
        }
        return ladderCollection.get(index - 1);
    }

    private Ladder createTemporaryLadder(Height height) {
        final List<Boolean> temporaryRungsStatus = rungsBuilder.buildTemporaryRungsStatus(height.value());
        return Ladder.from(temporaryRungsStatus);
    }

    private Ladder createNowLadder(Ladder prevLadder) {
        final List<Boolean> prevRungsStatus = prevLadder.getRungsStatus();
        final List<Boolean> nowRungsStatus = rungsBuilder.buildAndGetRungsStatus(prevRungsStatus);
        return Ladder.from(nowRungsStatus);
    }

}
