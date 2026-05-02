package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    public LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public Map<String, String> play(List<String> prize) {
        Players afterPlayers = movePlayers();
        return matchPrize(afterPlayers, prize);
    }

    private Players movePlayers() {
        return Players.fromPlayers(players.toList().stream()
                .map(this::rideLadder)
                .toList());
    }

    private Player rideLadder(Player player) {
        return new Player(player.name(), ladder.rideLadder(player.position()));
    }

    private Map<String, String> matchPrize(Players players, List<String> prize) {
        return players.toList().stream()
                .collect(Collectors.toMap(
                        Player::name,
                        player -> prize.get(player.position())
                ));
    }
}
