package util;

import java.util.Arrays;
import java.util.List;

import domain.Player;
import domain.Prize;

public class Parser {

    private static final String DELIMITER_REGEX = "\\s*,\\s*";

    public static List<Player> parsePlayers(String names) {
        return Arrays.stream(names.split(DELIMITER_REGEX))
            .map(Player::new)
            .toList();
    }

    public static List<Prize> parsePrizes(String prizes) {
        return Arrays.stream(prizes.split(DELIMITER_REGEX))
            .map(Prize::new)
            .toList();
    }

    public static int parseHeight(String height) {
        return Integer.parseInt(height);
    }
}
