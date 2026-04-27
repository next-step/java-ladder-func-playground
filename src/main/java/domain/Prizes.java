package domain;

import java.util.List;

public class Prizes {
    private static final int MAX_LENGTH = 5;
    private final List<String> prizeNames;

    public Prizes(List<String> prizeNames, int playerCount) {
        validateCount(prizeNames, playerCount);
        prizeNames.forEach(this::validateLength);
        this.prizeNames = List.copyOf(prizeNames);
    }

    public List<String> getPrizeNames() {
        return prizeNames;
    }

    private void validateCount(List<String> prizeNames, int playerCount) {
        if (prizeNames.size() != playerCount) {
            throw new IllegalArgumentException("인원 수와 상품 수는 같아야 합니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("실행 결과명은 5글자를 넘을 수 없습니다.");
        }
    }
}
