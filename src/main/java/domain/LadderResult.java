package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final List<String> prize;

    public LadderResult(List<String> prize) {
        this.prize = new ArrayList<>(prize);
    }

    public List<String> getPrizes() {
        return new ArrayList<>(prize);
    }

    public int size() {
        return prize.size();
    }
}
