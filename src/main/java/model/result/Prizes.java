package model.result;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public Prize getPrizeAt(int index) {
        return prizes.get(index);
    }

    public int size() {
        return prizes.size();
    }

    public List<Prize> getPrizes() {
        return List.copyOf(prizes);
    }
}
