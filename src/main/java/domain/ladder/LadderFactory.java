package domain.ladder;

import domain.player.Players;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import strategy.LineGenerator;

public class LadderFactory {

    private static final int MAX_ATTEMPTS = 50;

    public Ladder draw(final Players players, final Height height, final LineGenerator generator) {
        return findDrawableLadder(players, height, generator)
                .orElseThrow(() -> new IllegalArgumentException("유효한 사다리를 생성할 수 없습니다."));
    }

    private Optional<Ladder> findDrawableLadder(final Players players, final Height height,
                                                final LineGenerator generator) {
        return IntStream.range(0, MAX_ATTEMPTS)
                .mapToObj(attempt -> drawLadder(players, height, generator))
                .filter(ladder -> ladder.isFullyConnected(players))
                .findFirst();
    }

    private Ladder drawLadder(final Players players, final Height height, final LineGenerator lineGenerator) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.value(); i++) {
            lines.add(lineGenerator.generate(players.size()));
        }
        return Ladder.from(lines);
    }
}
