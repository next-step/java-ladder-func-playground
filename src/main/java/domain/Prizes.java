package domain;

import constant.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.MISMATCH_PLAYER_AND_PRIZE.getMessage());
        }
    }

    private void validateLength(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_OR_BLANK_NAME.getMessage());
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getIntFormattedMessage(MAX_LENGTH));
        }
    }
}
