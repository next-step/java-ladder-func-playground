package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrizeResults {
    private final List<PrizeResult> prizeResults;

    private PrizeResults(List<PrizeResult> prizeResults) {
        this.prizeResults = new ArrayList<>(prizeResults);
    }

    public static PrizeResults from(Map<String, String> ladderResult) {
        return new PrizeResults(ladderResult.entrySet().stream()
                .map(PrizeResult::from)
                .toList());
    }

    public PrizeResult findByName(String name) {
        return prizeResults.stream()
                .filter(result -> result.playerName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 플레이어는 없습니다."));
    }

    public List<PrizeResult> toList() {
        return new ArrayList<>(prizeResults);
    }
}
