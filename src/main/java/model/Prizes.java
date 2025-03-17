package model;

import java.util.List;

public class Prizes {

    private final List<Prize> prize;

    public Prizes(List<Prize> prize) {
        this.prize = prize;
    }

    public static Prizes form(List<String> result, Players players) {
        validatePrize(result, players);
        return new Prizes(generatePrize(result));
    }

    public List<String> getPrize() {
        return prize.stream()
                .map(Prize::getValue)
                .toList();
    }

    private static List<Prize> generatePrize(List<String> result) {
        return result.stream()
                .map(Prize::new)
                .toList();
    }

    private static void validatePrize(List<String> prizes, Players players) {
        if (prizes.size() != players.size()) {
            throw new IllegalArgumentException("실행결과 개수와 참가자의 수는 동일해야 합니다.");
        }
    }
}
