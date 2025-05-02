import Controller.LadderGameController;
import Domain.Players;
import Domain.Result;
import LadderDomain.Ladder;
import LadderDomain.LadderGame;
import View.InputHandler;

public class LadderApplication {
    public static void main(String[] args) {
        Players players = InputHandler.inputPlayersName();
        Result result = InputHandler.inputResult(players.size());
        int height = InputHandler.inputLadderSize();

        Ladder ladder = new Ladder(height, players.size());
        LadderGame game = new LadderGame(players, ladder, result);

        LadderGameController controller = new LadderGameController(players, game, ladder, result);
        controller.run();
    }
}

