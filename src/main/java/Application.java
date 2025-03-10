import domain.Ladder;
import utils.exception.ExceptionHandler;
import view.LadderView;

public class Application {
    public static void main(String[] args) {
        try {
            Ladder ladder = Ladder.of(4, 4);
            LadderView.printLadder(ladder);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
