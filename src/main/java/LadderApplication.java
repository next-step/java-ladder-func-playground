import domain.Ladder;
import strategy.PointGenerator;
import strategy.RandomGenerator;
import view.InputView;
import view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {

        int width = InputView.inputLadderWidth();
        int height = InputView.inputLadderHeight();

        PointGenerator generator = new RandomGenerator();
        Ladder ladder = Ladder.create(width, height, generator);

        OutputView.printLadderResultTitle();
        OutputView.paintLadder(ladder);
    }
}
