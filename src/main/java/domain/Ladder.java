package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final int width;

    public Ladder(int width, int height) {
        validateHeight(height);
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> Line.create(width))
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
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }
}
