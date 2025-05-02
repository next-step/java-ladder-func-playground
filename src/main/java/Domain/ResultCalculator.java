package Domain;

import LadderDomain.Ladder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultCalculator {
    public static PlayerResults calculate(PlayerNames playerNames, Ladder ladder, PrizeNames prizeNames) {
        List<Integer> endPositions = calculateEndPositions(playerNames, ladder);
        validate(endPositions, prizeNames);

        Map<PlayerName, PrizeName> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < playerNames.size(); i++) {
            resultMap.put(playerNames.get(i), prizeNames.get(endPositions.get(i)));
        }

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
