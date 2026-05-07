package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private static final int MAX_RESULT_LENGTH = 5;
    private final List<String> prizes;

    public LadderResult(List<String> prizes) {
        validateResults(prizes);
        this.prizes = new ArrayList<>(prizes);
    }

    public void validateEnoughSize(int playerSize) {
        if (playerSize > prizes.size()) {
            throw new IllegalArgumentException("실행 결과는 플레이어 수보다 적을 수 없습니다.");
        }
    }

    public List<String> getPrizes() {
        return new ArrayList<>(prizes);
    }

    public int size() {
        return prizes.size();
    }

    private void validateResults(List<String> prizes) {
        prizes.forEach(this::validateResult);
    }

    private void validateResult(String prize) {
        if (prize == null || prize.isBlank()) {
            throw new IllegalArgumentException("실행 결과가 입력되지 않았습니다.");
        }
        if (prize.length() > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException("실행 결과는 " + MAX_RESULT_LENGTH + "글자 이하입니다.");
        }
    }
}
