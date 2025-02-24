package util;

import java.util.Arrays;

import domain.Players;
import domain.Prizes;

public class Parser {

    private static final String DELIMITER_REGEX = "\\s*,\\s*";

    public static Players parsePlayers(String names) {
        return new Players(
            Arrays.stream(names.split(DELIMITER_REGEX)).toList()
        );
    }

    public static Prizes parsePrizes(String prizes) {
        return new Prizes(
            Arrays.stream(prizes.split(DELIMITER_REGEX)).toList()
        );
    }

    public static int parseHeight(String height) {
        return Integer.parseInt(height);
    }
}
