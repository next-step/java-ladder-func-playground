package dto;

import static constants.LadderConstants.MAX_NAME_LENGTH;

import java.util.List;
import java.util.stream.Collectors;

import domain.LadderGame;
import domain.Line;

public record LadderGameResponse(
    List<String> playerNames,
    List<List<Boolean>> ladder,
    List<String> prizeNames
) {

    public static LadderGameResponse from(LadderGame ladderGame) {
        return new LadderGameResponse(
            ladderGame.getGameData().getPlayers().getNames(),
            ladderGame.getLadder().getLines().stream()
                .map(Line::getPoints)
                .toList(),
            ladderGame.getGameData().getPrizes().getNames()
        );
    }

    public String formattedPlayerNames() {
        return playerNames.stream()
            .map(this::formatFixedWidth)
            .collect(Collectors.joining(" "));
    }

    public String formattedPrizeNames() {
        return prizeNames.stream()
            .map(this::formatFixedWidth)
            .collect(Collectors.joining(" "));
    }

    private String formatFixedWidth(String name) {
        if (name.length() >= MAX_NAME_LENGTH) {
            return name.substring(0, MAX_NAME_LENGTH);
        }
        return String.format("%-5s", name);
    }
}
