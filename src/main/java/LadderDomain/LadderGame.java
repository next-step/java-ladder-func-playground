package LadderDomain;

import Domain.PlayerName;
import Domain.PlayerResults;
import Domain.PrizeName;
import java.util.Map;


public class LadderGame {

    private final PlayerResults playerResults;

    public LadderGame(PlayerResults playerResults) {
        this.playerResults = playerResults;
    }

    public PrizeName findResultByName(PlayerName name) {
        return playerResults.get(name);
    }

    public Map<PlayerName, PrizeName> findAllResults() {
        return playerResults.getAll();
    }
}
