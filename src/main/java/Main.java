import controller.LadderController;
import domain.LadderResultCalculator;
import generator.LadderGenerator;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGenerator ladderGenerator = new LadderGenerator();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        LadderResultCalculator ladderResultCalculator = new LadderResultCalculator();

        LadderController ladderController = new LadderController(
                ladderGenerator,
                outputView,
                inputView,
                ladderResultCalculator
        );
        ladderController.run();
    }
}
