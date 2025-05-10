package domain;

import domain.prize.PrizeName;
import domain.prize.PrizeNames;
import domain.user.PlayerName;
import domain.user.PlayerNames;
import domain.user.PlayerResults;
import ladderdomain.Ladder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultCalculator {

    public static PlayerResults calculate(PlayerNames playerNames, Ladder ladder, PrizeNames prizeNames) {
        List<Integer> endPositions = calculateEndPositions(playerNames, ladder);
        validate(endPositions, prizeNames);

        Map<PlayerName, PrizeName> resultMap =
                IntStream.range(0, playerNames.size())
                        .boxed()
                        .collect(Collectors.toMap(
                                playerNames::getByIndex,
                                i -> prizeNames.getByIndex(endPositions.get(i)),
                                (a, b) -> a,
                                LinkedHashMap::new
                        ));

        return new PlayerResults(resultMap);
    }

    private static List<Integer> calculateEndPositions(PlayerNames playerNames, Ladder ladder) {
        return playerNames.toIntegerList().stream()
                .map(ladder::move)
                .toList();
    }

    private static void validate(List<Integer> endPositions, PrizeNames prizeNames) {
        boolean hasInvalid = endPositions.stream()
                .anyMatch(end -> end >= prizeNames.size());

        if (hasInvalid) {
            throw new IllegalStateException("사다리 결과 인덱스가 결과 수보다 큽니다.");
        }
    }
}
