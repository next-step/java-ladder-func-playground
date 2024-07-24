import java.util.Random;

import controller.Controller;
import view.InputView;
import view.OutputView;

public class Application {
    public static final InputView inputView = new InputView();
    public static final OutputView outputView = new OutputView();
    public static final Random random = new Random();

    public static void main(String[] args) {
        new Controller(inputView, outputView, random)
            .start();
    }
}
