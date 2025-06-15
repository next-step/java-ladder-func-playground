package domain.dto;

import domain.ladder.Height;
import domain.player.Players;
import domain.runningResult.Results;
import java.util.List;
import java.util.stream.Stream;

public record RequestLadderGame(
        String playerNames,
        String runningResults,
        String height
) {

    private static final String INPUT_DELIMITER = ",";

    public RequestLadderGame {
        validateEmptyPlayerNames(playerNames);
        validateEmptyResults(runningResults);
        validateEmptyHeight(height);
    }

    private static void validatePlayerCountEqualsResultsCount(final int playerCount, final List<String> results) {
        if (playerCount != results.size()) {
            throw new IllegalArgumentException("실행 결과 수는 플레이어 수와 동일해야 합니다.");
        }
    }

    private void validateEmptyPlayerNames(final String playerNames) {
        if (playerNames == null || playerNames.isBlank()) {
            throw new IllegalArgumentException("플레이어들의 이름은 공백이 아니어야 합니다.");
        }
    }

    private void validateEmptyResults(final String results) {
        if (results == null || results.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 공백이 아니어야 합니다.");
        }
    }

    private void validateEmptyHeight(final String height) {
        if (height == null || height.isBlank()) {
            throw new IllegalArgumentException("사다리의 높이는 공백이 아니어야 합니다.");
        }
    }

    public Players toPlayers() {
        List<String> names = Stream.of(playerNames.split(INPUT_DELIMITER))
                .map(String::strip)
                .toList();
        return Players.from(names);
    }

    public Height toHeight() {
        try {
            return new Height(Integer.parseInt(height.strip()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리의 높이는 숫자여야 합니다.");
        }
    }

    public Results toResults(final int playerCount) {
        List<String> results = Stream.of(runningResults.split(INPUT_DELIMITER))
                .map(String::strip)
                .toList();

        validatePlayerCountEqualsResultsCount(playerCount, results);
        return Results.from(results);
    }
}
