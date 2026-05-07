import controller.LadderController;
import generator.ConnectionGenerator;
import generator.RandomConnectionGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ConnectionGenerator connectionGenerator = new RandomConnectionGenerator();
        LadderController ladderController = new LadderController(inputView, outputView, connectionGenerator);
        ladderController.run();
    }
}
