import controller.LadderController;
import view.InputView;
import view.OutputView;
import service.LadderService;

public class LadderApplication {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LadderService ladderService = new LadderService();
        LadderController controller = new LadderController(inputView, outputView, ladderService);

        controller.start();
        processQueries(controller);

        // 종료
        System.exit(0);
    }

    private void processQueries(LadderController controller) {
        while (shouldContinue(controller)) {
        }
    }

    private boolean shouldContinue(LadderController controller) {
        return controller.processQuery();
    }
}
