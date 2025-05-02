package LadderDomain;

import Domain.PlayerName;
import Domain.PlayerResults;
import Domain.PrizeName;
import Domain.GameInformation;
import Domain.ResultCalculator;
import java.util.Map;


public class LadderGame {

    private final Ladder ladder;
    private final PlayerResults results;

    public LadderGame(GameInformation gameInformation, Ladder ladder) {
        this.ladder = ladder;
        this.results = ResultCalculator.calculate(
                gameInformation.getPlayerNames(),
                ladder,
                gameInformation.getPrizeNames()
        );
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
