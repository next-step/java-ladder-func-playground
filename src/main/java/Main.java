import controller.Controller;
import domain.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new RandomBooleanGenerator(), new InputView(), new OutputView());

        controller.run();
    }
}
