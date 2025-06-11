package domain.dto;

import domain.ladder.Ladder;
import domain.player.Players;
import java.util.List;
import java.util.stream.IntStream;

public record ResponseLadderResult(
        List<String> results
) {

    private static final String LADDER_RESULT_ARROW = " -> ";

    public static ResponseLadderResult of(final Ladder ladder, final Players players) {
        List<String> result = IntStream.range(0, players.values().size())
                .mapToObj(start -> start + LADDER_RESULT_ARROW + ladder.move(start))
                .toList();
        return new ResponseLadderResult(result);
    }
}
