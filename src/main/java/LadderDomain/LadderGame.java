package LadderDomain;

import Domain.PlayerName;
import Domain.Players;
import Domain.Result;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Result result;

    public LadderGame(Players players, Ladder ladder, Result result) {
        this.players = players;
        this.ladder = ladder;
        this.result = result;
    }

    public String findResultByName(PlayerName name) {
        int start = players.indexOf(name);
        int end = ladder.move(start);
        return result.get(end);
    }

    public Map<PlayerName, String> findAllResults() {
        Map<PlayerName, String> map = new LinkedHashMap<>();
        for (int i = 0; i < players.size(); i++) {
            int end = ladder.move(i);
            map.put(players.get(i), result.get(end));
        }
        return map;
    }
}
