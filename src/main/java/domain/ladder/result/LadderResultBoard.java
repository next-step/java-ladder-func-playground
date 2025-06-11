package domain.ladder.result;

import static java.util.stream.Collectors.toMap;

import domain.ladder.Ladder;
import domain.player.Players;
import domain.runningResult.Results;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

public class LadderResultBoard {
    private final List<LadderResult> ladderResults;
    private final Map<String, LadderResult> ladderResultCache;

    public LadderResultBoard(final List<LadderResult> ladderResults) {
        this.ladderResults = List.copyOf(ladderResults);
        this.ladderResultCache = ladderResults.stream()
                .collect(toMap(LadderResult::player, Function.identity()));
    }

    public static LadderResultBoard of(final Players players, final Ladder ladder, final Results results) {
        List<LadderResult> ladderResults = IntStream.range(0, players.values().size())
                .mapToObj(startIndex -> {
                    String playerName = players.values().get(startIndex).name().value();
                    int destinationIndex = ladder.move(startIndex);
                    String resultValue = results.asList().get(destinationIndex).value();
                    return new LadderResult(playerName, resultValue);
                })
                .toList();

        return new LadderResultBoard(ladderResults);
    }

    public Optional<String> findResultOf(final String playerName) {
        return Optional.ofNullable(ladderResultCache.get(playerName))
                .map(LadderResult::result);
    }

    public List<LadderResult> getAllResults() {
        return ladderResults;
    }
}
