package ladder.domain;

import java.util.List;

public class LadderResults {
    private final List<LadderResult> results;

    private LadderResults(List<LadderResult> results) {
        this.results = results;
    }

    public static LadderResults of(List<String> rawResults, int participantCount) {
        if (rawResults.size() != participantCount) {
            throw new IllegalArgumentException("참가자 수와 결과의 개수가 일치해야 합니다.");
        }

        List<LadderResult> results = rawResults.stream()
            .map(LadderResult::from)
            .toList();
        return new LadderResults(results);
    }

    public List<LadderResult> getValues() {
        return results;
    }
}
