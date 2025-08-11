import java.util.Random;
import java.util.Scanner;

import domain.Columns;
import domain.Ladder;
import domain.Rows;
import domain.RungLength;
import service.RandomConnectionGenerator;
import view.LadderRenderer;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("사다리의 넓이는 몇 개인가요?");
            int width = Integer.parseInt(scanner.nextLine().trim());

            System.out.println();
            System.out.println("사다리의 높이는 몇 개인가요?");
            int height = Integer.parseInt(scanner.nextLine().trim());

            System.out.println();
            System.out.println("실행결과");
            System.out.println();

            Columns columns = Columns.of(width);
            Rows rows = Rows.of(height);
            RungLength rungLength = RungLength.defaultFive();

            RandomConnectionGenerator generator = new RandomConnectionGenerator(new Random());
            Ladder ladder = generator.generateLadder(rows, columns);

            LadderRenderer renderer = new LadderRenderer();
            renderer.print(ladder, columns, rungLength);
        }
    }
}
