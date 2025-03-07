package domain;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        if (prizes == null || prizes.isEmpty()) {
            throw new IllegalArgumentException("결과는 비어 있을 수 없습니다.");
        }
        this.prizes = prizes;
    }

    public Prize getPrizeAt(int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
