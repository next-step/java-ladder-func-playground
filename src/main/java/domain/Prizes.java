package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    private Prizes(List<String> prizes) {
        this.prizes = prizes.stream()
                .map(Prize::create)
                .collect(Collectors.toList());
    }

    public static Prizes from(List<String> prizes) {
        validate(prizes);
        return new Prizes(prizes);
    }

    public int size() {
        return prizes.size();
    }

    public String labelAt(Integer resultIndex) {
        return prizes.get(resultIndex).label();
    }

    public List<String> labels() {
        return prizes.stream()
                .map(Prize::label)
                .collect(Collectors.toList());
    }

    private static void validate(List<String> prizes) {
        if (prizes == null || prizes.isEmpty()) {
            throw new IllegalArgumentException("상품은 하나 이상이어야 합니다.");
        }
    }
}
