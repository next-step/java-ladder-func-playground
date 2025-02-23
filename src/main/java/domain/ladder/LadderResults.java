package domain.ladder;

import java.util.List;

public class LadderResults {

    private final List<LadderResult> results;

    public LadderResults(List<String> results) {
        this.results = results.stream()
                .map(LadderResult::new)
                .toList();
    }

    public List<LadderResult> getAllLadderResults() {
        return results;
    }

    public LadderResult getLadderResult(int index) {
        if (validateOutOfBound(index)) {
            throw new IndexOutOfBoundsException(String.format("0~%d 사이로 입력해주세요.", results.size()));
        }
        return results.get(index);
    }

    private boolean validateOutOfBound(int index) {
        return index < 0 || index >= results.size();
    }
}
