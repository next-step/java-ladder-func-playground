package domain;

import dto.PrizeResult;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    public LadderGame(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public PrizeResults play(List<String> prizes) {
        Players afterPlayers = movePlayers();
        return matchPrize(afterPlayers, prizes);
    }

    private Players movePlayers() {
        return Players.fromPlayers(players.toList().stream()
                .map(this::rideLadder)
                .toList());
    }

    private Player rideLadder(Player player) {
        return new Player(player.name(), ladder.rideLadder(player.position()));
    }

    private PrizeResults matchPrize(Players players, List<String> prizes) {
        List<PrizeResult> prizeResults = players.toList().stream()
                .map(player -> new PrizeResult(
                        player.name(),
                        prizes.get(player.position())
                ))
                .toList();

        return PrizeResults.from(prizeResults);
    }
}
