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

    private final Map<String, LadderResult> playerResultMap;

    private LadderResultBoard(final Map<String, LadderResult> playerResultMap) {
        this.playerResultMap = Map.copyOf(playerResultMap);
    }

    public static LadderResultBoard of(final Players players, final Ladder ladder, final Results results) {
        Map<String, LadderResult> playerResultMap = IntStream.range(0, players.size())
                .mapToObj(startIndex -> {
                    String playerName = players.name(startIndex);
                    int destinationIndex = ladder.move(startIndex);
                    String resultValue = results.value(destinationIndex);
                    return new LadderResult(playerName, resultValue);
                })
                .collect(toMap(LadderResult::playerName, Function.identity()));
        return new LadderResultBoard(playerResultMap);
    }

    public Optional<String> findResultOf(final String playerName) {
        return Optional.ofNullable(playerResultMap.get(playerName))
                .map(LadderResult::result);
    }

    public List<LadderResult> getAllResults() {
        return List.copyOf(playerResultMap.values());
    }
}
