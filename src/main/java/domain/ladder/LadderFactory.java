package domain.ladder;

import exception.DomainRuleViolationException;
import java.util.ArrayList;
import java.util.List;

public final class LadderFactory {

    private final LineIndexGenerator lineIndexGenerator;

    public LadderFactory(LineIndexGenerator lineIndexGenerator) {
        this.lineIndexGenerator = lineIndexGenerator;
    }

    public Ladder create(int height, int playerCount) {
        validateHeight(height);
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            List<Integer> randomIndexes = lineIndexGenerator.generate(playerCount);
            Line line = Line.fromRandomIndex(randomIndexes, playerCount - 1);
            lines.add(line);
        }

        return new Ladder(lines);
    }

    private void validateHeight(int height) {
        if (height <= 0) {
            throw new DomainRuleViolationException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }
}
