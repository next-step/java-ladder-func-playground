import java.util.List;

import view.InputView;
import controller.LadderGameController;

public class Main {
    public static void main(String[] args) {
        List<String> names = InputView.getPlayerNames();
        List<String> results = InputView.getResults();
        int height = InputView.getLadderHeight();

        LadderGameController game = new LadderGameController(names, results, height);
        game.play();
    }
}