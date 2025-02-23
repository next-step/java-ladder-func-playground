import controller.LadderController;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController();
        ladderController.run();
        InputView.closeScanner();
    }
}
