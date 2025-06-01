package domain.ladder;

import domain.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import strategy.LineGenerator;

public class LadderFactory {

    private static final int MAX_ATTEMPTS = 50;

    public Ladder draw(final int width, final int height, final LineGenerator generator) {
        return findDrawableLadder(width, height, generator)
                .orElseThrow(() -> new IllegalArgumentException("유효한 사다리를 생성할 수 없습니다."));
    }

    private Optional<Ladder> findDrawableLadder(final int width, final int height, final LineGenerator generator) {
        for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
            Ladder ladder = drawLadder(width, height, generator);
            if (ladder.isFullyConnected(width)) {
                return Optional.of(ladder);
            }
        }
        return Optional.empty();
    }

    private Ladder drawLadder(final int width, final int height, final LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generate(width));
        }
        return Ladder.from(lines);
    }
}
