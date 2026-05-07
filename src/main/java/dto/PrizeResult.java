package dto;

import java.util.Map;

public record PrizeResult(String playerName, String prize) {

    public static PrizeResult from(Map.Entry<String, String> entry) {
        return new PrizeResult(entry.getKey(), entry.getValue());
    }
}
