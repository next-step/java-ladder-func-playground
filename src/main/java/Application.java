import controller.LadderController;
import domain.LineIndexGenerator;
import domain.RandomLineIndexGenerator;
import java.util.Random;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {

        LineIndexGenerator lineIndexGenerator = new RandomLineIndexGenerator(new Random());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        new LadderController(
                lineIndexGenerator, inputView, outputView)
                .run();
    }
}
