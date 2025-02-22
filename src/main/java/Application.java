import controller.LadderController;
import service.LadderService;
import view.LadderInputView;
import view.LadderOutputView;

public class Application {

    public static void main(String[] args) {
        LadderService ladderService = new LadderService();
        LadderInputView inputView = new LadderInputView();
        LadderOutputView outputView = new LadderOutputView();
        LadderController ladderController = new LadderController(ladderService, inputView, outputView);

        ladderController.play();
    }
}
