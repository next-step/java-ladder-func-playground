package domain;

import static constants.LadderConstants.MAX_NAME_LENGTH;

import java.util.List;

import exception.InvalidPlayerNameException;
import exception.InvalidPrizeException;

public class Prizes {

    private final List<String> names;

    public Prizes(List<String> names) {
        validatePrizes(names);
        this.names = List.copyOf(names);
    }

    private void validatePrizes(List<String> prizes) {
        validatePrizeListNotNullOrEmpty(prizes);
        for (String prize : prizes) {
            validatePrizeNotNullOrEmpty(prize);
            validateNameLength(prize);
        }
    }

    private void validatePrizeListNotNullOrEmpty(List<String> prizes) {
        if (prizes == null || prizes.isEmpty()) {
            throw new InvalidPrizeException("상품 목록은 비어있을 수 없습니다.");
        }
    }

    private void validatePrizeNotNullOrEmpty(String prize) {
        if (prize == null || prize.isBlank()) {
            throw new InvalidPrizeException("상품 이름은 null이나 빈 문자열이 될 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidPlayerNameException("상품 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
