import controller.LadderController;
import domain.LadderBuilder;
import domain.LadderGenerator;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGenerator ladderGenerator = new LadderGenerator();
        LadderBuilder ladderBuilder = new LadderBuilder();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        LadderController ladderController = new LadderController(ladderGenerator, ladderBuilder, outputView, inputView);
        ladderController.run();
    }
}
