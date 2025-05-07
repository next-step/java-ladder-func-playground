package ladderdomain;

import domain.PlayerName;
import domain.PlayerResults;
import domain.PrizeName;
import domain.GameInformation;
import java.util.Map;


public class LadderGame {

    private final Ladder ladder;
    private final PlayerResults results;

    public LadderGame(GameInformation gameInformation, Ladder ladder) {
        this.ladder = ladder;
        this.results = gameInformation.calculateResults(ladder);
    }

    public PrizeName findResultByName(PlayerName name) {
        return results.get(name);
    }

    public Map<PlayerName, PrizeName> findAllResults() {
        return results.getAll();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
