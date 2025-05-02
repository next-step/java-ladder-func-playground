import Controller.LadderGameController;
import Domain.PlayerNames;
import Domain.PlayerResults;
import Domain.PrizeNames;
import LadderDomain.Ladder;
import LadderDomain.LadderGame;
import View.InputHandler;

public class LadderApplication {
    public static void main(String[] args) {
        PlayerNames playerNames = InputHandler.inputPlayersName();
        PrizeNames prizeNames = InputHandler.inputPrizeNames(playerNames.size());
        int height = InputHandler.inputLadderSize();

        Ladder ladder = new Ladder(height, playerNames.size());

        PlayerResults playerResults = PlayerResults.of(playerNames, ladder, prizeNames);
        LadderGame game = new LadderGame(playerResults);

        LadderGameController controller = new LadderGameController(playerNames, game, ladder, prizeNames);
        controller.run();
    }
}

