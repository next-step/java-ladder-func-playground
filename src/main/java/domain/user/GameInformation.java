package domain.user;

import domain.prize.PrizeNames;
import domain.ResultCalculator;

public class GameInformation {

    private final PlayerNames playerNames;
    private final PrizeNames prizeNames;

    public GameInformation(PlayerNames playerNames, PrizeNames prizeNames) {
        this.playerNames = playerNames;
        this.prizeNames = prizeNames;
    }

    public PlayerNames getPlayerNames() {
        return playerNames;
    }

    public PrizeNames getPrizeNames() {
        return prizeNames;
    }

    public PlayerResults calculateResults(ladderdomain.Ladder ladder) {
        return ResultCalculator.calculate(playerNames, ladder, prizeNames);
    }
}
