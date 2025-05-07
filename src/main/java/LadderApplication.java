import controller.LadderGameController;
import domain.GameInformation;
import domain.PlayerNames;
import domain.PrizeNames;
import ladderdomain.Ladder;
import ladderdomain.LadderGame;
import view.InputHandler;

public class LadderApplication {
    public static void main(String[] args) {
        PlayerNames playerNames = InputHandler.inputPlayersName();
        PrizeNames prizeNames = InputHandler.inputPrizeNames(playerNames.size());
        int height = InputHandler.inputLadderSize();

        Ladder ladder = new Ladder(height, playerNames.size());
        GameInformation gameInformation = new GameInformation(playerNames, prizeNames);
        LadderGame game = new LadderGame(gameInformation, ladder);

        LadderGameController controller = new LadderGameController(game, gameInformation);
        controller.run();
    }
}

