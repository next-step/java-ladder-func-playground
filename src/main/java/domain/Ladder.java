package domain;

import domain.dto.LadderDto;
import java.util.HashSet;
import java.util.Set;
import util.Errors;

public class Ladder {

    private final Set<Integer> rungPositions;

    private Ladder(Set<Integer> rungPositions) {
        this.rungPositions = new HashSet<>(rungPositions);
    }

    public static Ladder from(LadderDto ladderDto, int height) {
        final Set<Integer> rungPositions = ladderDto.getRungPositions();
        validateRungPositions(rungPositions, height);
        return new Ladder(rungPositions);
    }

    private static void validateRungPositions(Set<Integer> rungPositions, int maxPosition) {
        for (Integer rungPosition : rungPositions) {
            validateRungPosition(rungPosition, maxPosition);
        }
    }

    private static void validateRungPosition(Integer rungPosition, int maxPosition) {
        if (rungPosition < 0 || rungPosition >= maxPosition) {
            throw new IllegalArgumentException(Errors.POSITION_INDEX_OUT_OF_RANGE);
        }
    }

    public Set<Integer> getRungPositions() {
        return new HashSet<>(rungPositions);
    }
}
