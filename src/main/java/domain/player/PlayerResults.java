package domain.player;

import domain.ladder.Ladder;
import exception.DomainNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
        List<PlayerResult> playerResults = new ArrayList<>();
        List<String> names = players.names();
        List<String> values = rewards.values();

        for (int start = 0; start < players.size(); start++) {
            int destination = ladder.getDestination(start);
            playerResults.add(new PlayerResult(names.get((start)), values.get(destination)));
        }

        return new PlayerResults(playerResults);
    }
}
