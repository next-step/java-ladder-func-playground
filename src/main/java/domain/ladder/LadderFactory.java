package domain.ladder;

import domain.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import strategy.LineGenerator;

public class LadderFactory {

    private static final int MAX_ATTEMPTS = 50;

    public Ladder draw(final int width, final int height, final LineGenerator generator) {
        return findDrawableLadder(width, height, generator)
                .orElseThrow(() -> new IllegalArgumentException("유효한 사다리를 생성할 수 없습니다."));
    }

    private Optional<Ladder> findDrawableLadder(final int width, final int height, final LineGenerator generator) {
        return IntStream.range(0, MAX_ATTEMPTS)
                .mapToObj(attempt -> drawLadder(width, height, generator))
                .filter(ladder -> ladder.isFullyConnected(width))
                .findFirst();
    }

    private Ladder drawLadder(final int width, final int height, final LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(width));
        }
        return Ladder.from(lines);
    }
}
