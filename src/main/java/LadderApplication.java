import domain.Ladder;
import strategy.PointGenerator;
import strategy.RandomGenerator;
import view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        int width = 4;
        int height = 4;

        PointGenerator generator = new RandomGenerator();
        Ladder ladder = Ladder.create(width, height, generator);

        OutputView.printLadderResultTitle();
        OutputView.paintLadder(ladder);
    }
}
