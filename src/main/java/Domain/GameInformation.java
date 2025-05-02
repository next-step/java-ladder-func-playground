package Domain;

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
}
