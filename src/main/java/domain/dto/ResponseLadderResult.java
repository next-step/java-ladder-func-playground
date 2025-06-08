package domain.dto;

import domain.Width;
import domain.ladder.Ladder;
import java.util.List;
import java.util.stream.IntStream;

public record ResponseLadderResult(
        List<String> results
) {

    private static final String LADDER_RESULT_ARROW = " -> ";

    public static ResponseLadderResult of(final Ladder ladder, final Width width) {
        List<String> result = IntStream.range(0, width.value())
                .mapToObj(start -> start + LADDER_RESULT_ARROW + ladder.move(start))
                .toList();
        return new ResponseLadderResult(result);
    }
}
