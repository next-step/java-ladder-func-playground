package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PlayerResults {

    private static final String ERROR_RESULT_COUNT_MISMATCH = "[ERROR] 실행 결과 수가 참여자 수와 일치해야 합니다.";

    private final Map<String, String> resultByPlayerName;

    private PlayerResults(Map<String, String> resultByPlayerName) {
        this.resultByPlayerName = resultByPlayerName;
    }

    public static PlayerResults from(Participants participants, List<String> outcomeLabels, Map<Integer, Integer> startToEndIndexMap) {
        validateSizeMatch(participants, outcomeLabels);
        Map<String, String> mappedResults = mapResults(participants.getNames(), outcomeLabels, startToEndIndexMap);
        return new PlayerResults(mappedResults);
    }

    public String resultOf(String playerName) {
        return resultByPlayerName.get(playerName);
    }

    public Map<String, String> allResults() {
        return resultByPlayerName;
    }

    public boolean hasPlayer(String playerName) {
        return resultByPlayerName.containsKey(playerName);
    }

    private static void validateSizeMatch(Participants participants, List<String> outcomeLabels) {
        if (participants.getCount() != outcomeLabels.size()) {
            throw new IllegalArgumentException(ERROR_RESULT_COUNT_MISMATCH);
        }
    }

    private static Map<String, String> mapResults(List<String> names, List<String> labels, Map<Integer, Integer> indexMap) {
        return IntStream.range(0, names.size())
                .collect(LinkedHashMap::new,
                        (map, i) -> map.put(names.get(i), labels.get(indexMap.get(i))),
                        Map::putAll);
    }
}
