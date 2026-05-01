package domain;

import constant.ErrorMessage;
import domain.strategy.BooleanGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final static int MIN_HEIGHT = 1;

    private final List<LadderBridge> ladderBridges;
    private final int width;

     Ladder(int width, int height, List<LadderBridge> ladderBridges) {
        validateHeight(height);
        this.width = width;
        this.ladderBridges = ladderBridges;
    }

    public static Ladder of(int width, int height, BooleanGenerator booleanGenerator) {
        List<LadderBridge> ladderBridges = IntStream.range(0, height)
                .mapToObj(i -> new LadderBridge(width, booleanGenerator))
                .toList();

        return new Ladder(width, height, ladderBridges);
    }

    public List<LadderBridge> getBridges() {
        return List.copyOf(ladderBridges);
    }

    public List<Integer> getAllResult() {
        return IntStream.range(0, width)
                .map(this::getResult)
                .boxed()
                .toList();
    }

    private int getResult(int index) {
        int currentIndex = index;
        for (LadderBridge line : ladderBridges) {
            currentIndex = line.calculateNextPosition(currentIndex);
        }
        return currentIndex;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_HEIGHT.getIntFormattedMessage(MIN_HEIGHT));
        }
    }
}
