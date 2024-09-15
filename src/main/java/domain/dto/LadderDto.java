package domain.dto;

import java.util.HashSet;
import java.util.Set;

public class LadderDto {

    private final Set<Integer> rungPositions;

    private LadderDto(Set<Integer> rungPositions) {
        this.rungPositions = rungPositions;
    }

    public static LadderDto of(int initialRungPosition) {
        final Set<Integer> rungIndexes = new HashSet<>();
        rungIndexes.add(initialRungPosition);
        return new LadderDto(rungIndexes);
    }

    public static LadderDto defaultInstance() {
        Set<Integer> rungPositions = new HashSet<>();
        return new LadderDto(rungPositions);
    }

    public void addRungs(Set<Integer> rungPositions) {
        this.rungPositions.addAll(rungPositions);
    }

    public Set<Integer> getRungPositions() {
        return rungPositions;
    }

}
