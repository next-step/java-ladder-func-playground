package domain.dto;

import domain.ladder.Height;
import domain.player.Players;
import java.util.List;
import java.util.stream.Stream;

public record RequestLadderGame(
        String playerNames,
        String height
) {

    static final String NAME_DELIMITER = ",";

    public RequestLadderGame {
        validateEmptyPlayerNames(playerNames);
        validateEmptyHeight(height);
    }

    private void validateEmptyPlayerNames(final String playerNames) {
        if (playerNames == null || playerNames.isBlank()) {
            throw new IllegalArgumentException("플레이어들의 이름을 입력해야 합니다.");
        }
    }

    private void validateEmptyHeight(final String height) {
        if (height == null || height.isBlank()) {
            throw new IllegalArgumentException("사다리의 높이를 입력해야 합니다.");
        }
    }

    public Players toPlayers() {
        List<String> names = Stream.of(playerNames.split(NAME_DELIMITER))
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

}
