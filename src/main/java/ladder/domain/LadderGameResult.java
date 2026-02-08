package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<Name, LadderResult> gameResults;

    private LadderGameResult(Map<Name, LadderResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static LadderGameResult of(Participants participants, LadderResults results, Map<Integer, Integer> ladderPath) {
        Map<Name, LadderResult> mappedResult = new LinkedHashMap<>();

        for (int i = 0; i < participants.size(); i++) {
            Name participant = participants.getValues().get(i);
            int arrivalIndex = ladderPath.get(i);
            LadderResult result = results.getValues().get(arrivalIndex);

            mappedResult.put(participant, result);
        }

        return new LadderGameResult(mappedResult);
    }

    public String getResultByName(String name) {
        return gameResults.entrySet().stream()
            .filter(entry -> entry.getKey().getName().equals(name))
            .map(entry -> entry.getValue().getValue())
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 이름의 참가자가 없습니다."));
    }

    public Map<Name, LadderResult> getAllResults() {
        return Collections.unmodifiableMap(gameResults);
    }

}
