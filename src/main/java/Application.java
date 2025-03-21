import controller.LadderController;
import dto.LadderDto;
import utils.exception.ExceptionHandler;
import view.LadderView;

public class Application {
    public static void main(String[] args) {
        try {
            LadderController ladderController = new LadderController();
            LadderDto ladderDto = ladderController.getLadderData();
            LadderView.printLadder(ladderDto);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
