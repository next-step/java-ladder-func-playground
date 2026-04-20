package domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public Map<String, Integer> play(Players players) {
        return players.toList().stream()
                .collect(Collectors.toMap(
                        Player::name,
                        player -> ladder.rideLadder(player.position())
                ));
    }
}
