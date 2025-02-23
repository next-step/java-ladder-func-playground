import controller.LadderController;
import domain.RandomBooleanGenerator;
import service.LadderService;
import view.LadderInputView;
import view.LadderOutputView;

public class Application {

    public static void main(String[] args) {
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
        LadderService ladderService = new LadderService(randomBooleanGenerator);
        LadderInputView inputView = new LadderInputView();
        LadderOutputView outputView = new LadderOutputView();
        LadderController ladderController = new LadderController(ladderService, inputView, outputView);

        ladderController.play();
    }
}
