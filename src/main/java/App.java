import java.util.Random;

import domain.Columns;
import domain.Ladder;
import domain.Rows;
import domain.RungLength;
import service.RandomConnectionGenerator;
import view.LadderRenderer;

public class App {
    public static void main(String[] args) {
        Columns columns = Columns.fixedFour();
        Rows rows = Rows.fixedFour();
        RungLength rungLength = RungLength.defaultFive();

        RandomConnectionGenerator generator = new RandomConnectionGenerator(new Random());
        Ladder ladder = generator.generateLadder(rows, columns);

        LadderRenderer renderer = new LadderRenderer();
        renderer.print(ladder, columns, rungLength);
    }
}


