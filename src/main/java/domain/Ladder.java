package domain;

import domain.value.Height;
import java.util.HashSet;
import java.util.Set;
import util.Errors;

public class Ladder {

    private final Set<Integer> rungIndexes;
    private final Height height;

    public Ladder(Height height) {
        this.height = height;
        this.rungIndexes = new HashSet<>();
    }

    public void createRungsAt(Set<Integer> newRungsPositionAtLadder) {
        for (Integer position : newRungsPositionAtLadder) {
            createRungsAt(position);
        }
    }

    public void createRungsAt(int position) {
        if (position < 0 || position >= height.getValue()) {
            throw new IllegalArgumentException(Errors.POSITION_INDEX_OUT_OF_RANGE);
        }
        rungIndexes.add(position);
    }

    public Set<Integer> getRungsPosition() {
        return new HashSet<>(rungIndexes);
    }
}
