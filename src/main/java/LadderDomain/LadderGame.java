package LadderDomain;

import Domain.Name;
import Domain.Players;
import Domain.Result;
import Domain.Results;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Results results;

    public LadderGame(Players players, Ladder ladder, Results results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    public Result findResultByName(Name name) {
        int start = players.indexOf(name);
        int end = ladder.move(start);
        return results.get(end);
    }

    public Map<Name, Result> findAllResults() {
        Map<Name, Result> map = new LinkedHashMap<>();
        for (int i = 0; i < players.size(); i++) {
            int end = ladder.move(i);
            map.put(players.get(i).getName(), results.get(end));
        }
        return map;
    }
}
