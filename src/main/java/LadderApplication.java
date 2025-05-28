import domain.Ladder;
import domain.Line;
import java.util.ArrayList;
import java.util.List;
import strategy.PointGenerator;
import strategy.RandomGenerator;
import view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        int width = 4;
        int height = 4;

        PointGenerator generator = new RandomGenerator();

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.create(width, generator));
        }

        Ladder ladder = new Ladder(lines);

        OutputView.printLadderResultTitle();
        OutputView.paintLadder(ladder);
    }
}
