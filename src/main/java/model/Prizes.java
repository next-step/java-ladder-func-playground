package model;

import constants.ErrorMessage;

import java.util.List;

public class Prizes {
    private final List<String> prizes;

    public Prizes(List<String> prizes) {
        this.validatePrize(prizes);
        this.prizes = prizes;
    }

    private void validatePrize(List<String> prizes) {
        validatePrizeLength(prizes);
    }

    private void validatePrizeLength(List<String> prizes) {
        prizes.stream()
                .filter(name -> name.length() > 5)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(ErrorMessage.NAME_LONGER_THAN_LIMIT.getMessage());
                });
    }


    public String getPrizeByIndex(int index) {
        return prizes.get(index);
    }

    public Integer prizeCount() {
        return prizes.size();
    }
}
