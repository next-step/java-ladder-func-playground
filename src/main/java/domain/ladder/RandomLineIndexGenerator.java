package domain.ladder;

import exception.DomainRuleViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineIndexGenerator implements LineIndexGenerator {

    private final Random random;
    private final double bridgeProbability;

    public RandomLineIndexGenerator(Random random, double bridgeProbability) {
        this.random = random;
        this.bridgeProbability = bridgeProbability;
    }

    @Override
    public List<Integer> generate(int lineSize) {
        validateLineSize(lineSize);

        int gapCount = lineSize - 1;
        List<Integer> bridgeIndexes = new ArrayList<>();
        int gapIndex = 0;

        while (gapIndex < gapCount) {
            gapIndex = getNextGapIndex(gapIndex, bridgeIndexes);
        }

        if (bridgeIndexes.isEmpty()) {
            bridgeIndexes.add(random.nextInt(gapCount));
        }
        return bridgeIndexes;
    }

    private void validateLineSize(int lineSize) {
        if (lineSize < 2) {
            throw new DomainRuleViolationException("사다리의 넓이는 2 이상이어야 합니다.");
        }
    }

    private int getNextGapIndex(int gapIndex, List<Integer> bridgeIndexes) {
        if (random.nextDouble() >= bridgeProbability) {
            return gapIndex + 1;
        }
        bridgeIndexes.add(gapIndex);
        return gapIndex + 2;
    }
}
