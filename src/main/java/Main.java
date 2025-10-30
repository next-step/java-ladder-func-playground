import controller.LadderController;
import domain.LadderGame;
import domain.Players;
import domain.Results;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LadderController controller = new LadderController(inputView, outputView);

        Players players = controller.inputPlayers();
        Results results = controller.inputResults();
        int height = controller.inputHeight();

        LadderGame game = controller.startLadderGame(height, players, results);
        controller.showResult(game, players);

    }
}
