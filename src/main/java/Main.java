import controller.GenerateLadderController;
import controller.LadderResultOutputController;
import model.Ladder;
import model.LadderBuilder;
import model.LineBuilder;
import model.RandomizedLineBuilder;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        LineBuilder lineBuilder = new RandomizedLineBuilder();
        LadderBuilder ladderBuilder = new LadderBuilder(lineBuilder);
        OutputView outputView = new OutputView();

        GenerateLadderController generateLadderController = new GenerateLadderController(ladderBuilder);
        Ladder ladder = generateLadderController.generateLadder();

        LadderResultOutputController ladderResultOutputController = new LadderResultOutputController(ladder, outputView);
        ladderResultOutputController.printLadder();
    }
}
