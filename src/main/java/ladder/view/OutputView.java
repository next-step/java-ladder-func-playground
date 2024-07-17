package ladder.view;

import java.util.List;

import ladder.domain.Line;

public class OutputView {
    public static void printLadder(List<Line> ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            printLine(ladder.get(i));
        }
    }

    private static void printLine(Line line) {
        System.out.print("|");
        for (int i = 0; i < 4; i++) {
            if (line.getLine().get(i)) {
                System.out.print("-----");
            } else {
                System.out.print("     ");
            }
            System.out.print("|");
        }
        System.out.println();
    }
}
