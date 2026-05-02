package domain;

import dto.PrizeResult;

import java.util.ArrayList;
import java.util.List;

public class PrizeResults {
    private final List<PrizeResult> prizeResults;

    private PrizeResults(List<PrizeResult> prizeResults) {
        this.prizeResults = new ArrayList<>(prizeResults);
    }

    public static PrizeResults from(List<PrizeResult> prizeResults) {
        return new PrizeResults(prizeResults);
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
