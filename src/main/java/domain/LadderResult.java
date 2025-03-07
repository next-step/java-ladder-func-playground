package domain;

import java.util.List;

public class LadderResult {
    private final List<Position> positions;

    public LadderResult(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
