import controller.LadderController;
import domain.Ladder;

public class LadderApplication {
    public static void main(String[] args) {
        final LadderController ladderController = new LadderController();
        Ladder ladder = ladderController.createLadder();
        ladderController.printResult(ladder);
    }
}
