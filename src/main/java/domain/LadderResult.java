package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final List<String> prize;

    public LadderResult(List<String> prize) {
        this.prize = new ArrayList<>(prize);
    }

    public void validateEnoughSize(int playerSize) {
        if (playerSize > prize.size()) {
            throw new IllegalArgumentException("실행 결과는 플레이어 수보다 적을 수 없습니다.");
        }
    }

    public List<String> getPrizes() {
        return new ArrayList<>(prize);
    }

    public int size() {
        return prize.size();
    }
}
