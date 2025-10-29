import controller.LadderController;
import domain.LadderBuilder;
import domain.LadderGenerator;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LadderGenerator ladderGenerator = new LadderGenerator();
        LadderBuilder ladderBuilder = new LadderBuilder();
        OutputView outputView = new OutputView();

        LadderController ladderController = new LadderController(ladderGenerator, ladderBuilder, outputView);
        ladderController.run();
    }
}
