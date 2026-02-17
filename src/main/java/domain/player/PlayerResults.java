package domain.player;

import domain.ladder.Ladder;
import exception.DomainNotFoundException;
import java.util.List;
import java.util.stream.IntStream;

public final class PlayerResults {

    private final List<PlayerResult> playerResults;

    private PlayerResults(List<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public String findResultByName(String name) {
        return playerResults.stream()
                .filter(playerResult -> playerResult.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new DomainNotFoundException("존재하지 않는 참가자입니다."))
                .result();
    }

    public List<PlayerResult> findAllResults() {
        return playerResults;
    }

    public static PlayerResults of(Ladder ladder, Players players, Rewards rewards) {
        List<String> names = players.names();
        List<String> values = rewards.values();

        List<PlayerResult> playerResults = IntStream.range(0, players.size())
                .mapToObj(start -> {
                    int destination = ladder.getDestination(start);
                    return new PlayerResult(names.get(start), values.get(destination));
                })
                .toList();

        return new PlayerResults(playerResults);
    }
}
