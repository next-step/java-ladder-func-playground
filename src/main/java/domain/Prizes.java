package domain;

import java.util.List;

import exception.InvalidPrizeException;

public class Prizes {

    private static final int MAX_NAME_LENGTH = 5;
    private final List<String> names;

    public Prizes(List<String> names) {
        validatePrizes(names);
        this.names = List.copyOf(names);
    }

    private void validatePrizes(List<String> prizes) {
        validatePrizeListNotNullOrEmpty(prizes);
        for (String prize : prizes) {
            validatePrizeNotNullOrEmpty(prize);
        }
    }

    private void validatePrizeListNotNullOrEmpty(List<String> prizes) {
        if (prizes == null || prizes.isEmpty()) {
            throw new InvalidPrizeException("상품 목록은 비어있을 수 없습니다.");
        }
    }

    private void validatePrizeNotNullOrEmpty(String prize) {
        if (prize == null || prize.isEmpty()) {
            throw new InvalidPrizeException("상품은 null이나 빈 문자열이 될 수 없습니다.");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
