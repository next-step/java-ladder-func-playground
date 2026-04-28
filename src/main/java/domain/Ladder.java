package domain;

import constant.ErrorMessage;
import domain.strategy.BooleanGenerator;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final static int MIN_HEIGHT = 1;

    private final List<Line> lines;
    private final int width;

    public Ladder(int width, int height, BooleanGenerator booleanGenerator) {
        validateHeight(height);
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> Line.create(width, booleanGenerator))
                .toList();
        this.width = width;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

    public List<Integer> getAllResult() {
        return IntStream.range(0, width)
                .map(this::getResult)
                .boxed()
                .toList();
    }

    private int getResult(int index) {
        int currentIndex = index;
        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_HEIGHT.getIntFormattedMessage(MIN_HEIGHT));
        }
    }
}
