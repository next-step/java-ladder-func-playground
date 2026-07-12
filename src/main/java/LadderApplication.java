import controller.LadderController;
import view.InputView;
import view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputview = new InputView();
        OutputView outputview = new OutputView();

        LadderController ladderController = new LadderController(inputview, outputview);
        ladderController.run();
    }
}
