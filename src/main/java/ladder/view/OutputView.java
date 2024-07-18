package ladder.view;

import java.util.List;

import ladder.domain.Line;
import ladder.message.ConsoleMessage;

public class OutputView {

    public static void printLadder(List<Line> ladder) {
        System.out.println(ConsoleMessage.RESULT.getMessage());
        for (int i = 0; i < ladder.size(); i++) {
            printLine(ladder.get(i));
        }
    }

    private static void printLine(Line line) {
        System.out.print("|");
        for (int i = 0; i < line.getWidth() - 1; i++) {
            if (line.getLine().get(i)) {
                System.out.print("-----");
            } else {
                System.out.print("     ");
            }
            System.out.print("|");
        }
        System.out.println();
    }

    public static void printResult(List<Integer> result){
        for(int i = 0; i < result.size(); i++){
            System.out.println(i + " -> " + result.get(i));
        }
    }
}
