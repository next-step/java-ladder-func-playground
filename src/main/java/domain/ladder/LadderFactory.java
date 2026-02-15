package domain.ladder;

import exception.DomainRuleViolationException;
import java.util.List;
import java.util.stream.IntStream;

public final class LadderFactory {

    private final LineIndexGenerator lineIndexGenerator;

    public LadderFactory(LineIndexGenerator lineIndexGenerator) {
        this.lineIndexGenerator = lineIndexGenerator;
    }

    public Ladder create(int height, int playerCount) {
        validateHeight(height);

        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> {
                    List<Integer> lineIndexes = lineIndexGenerator.generate(playerCount);
                    return Line.of(lineIndexes, playerCount - 1);
                })
                .toList();

        return new Ladder(lines);
    }

    private void validateHeight(int height) {
        if (height <= 0) {
            throw new DomainRuleViolationException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }
}
