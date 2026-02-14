import controller.LadderController;
import domain.ladder.LadderFactory;
import domain.ladder.LadderPolicy;
import domain.ladder.LineIndexGenerator;
import domain.ladder.RandomLineIndexGenerator;
import java.util.Random;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LineIndexGenerator lineIndexGenerator = new RandomLineIndexGenerator(new Random(),
                LadderPolicy.DEFAULT_BRIDGE_PROBABILITY);
        LadderFactory ladderFactory = new LadderFactory(lineIndexGenerator);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        new LadderController(ladderFactory, inputView, outputView)
                .run();
    }
}
