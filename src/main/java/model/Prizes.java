package model;

import java.util.ArrayList;
import java.util.List;

import exception.CustomException;
import exception.ErrorMessage;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<String> prizes) {
        validateEmpty(prizes);
        this.prizes = init(prizes);
    }

    private void validateEmpty(List<String> prizes) {
        if (prizes == null || prizes.isEmpty()) {
            throw new CustomException(ErrorMessage.PRIZES_EMPTY);
        }
    }

    private List<Prize> init(List<String> prizes) {
        List<Prize> result = new ArrayList<>();

        for (String name : prizes) {
            result.add(new Prize(name));
        }

        return result;
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
