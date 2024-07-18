package ladder.view;

import java.util.List;
import java.util.Map;

import ladder.domain.Line;
import ladder.message.ConsoleMessage;

public class OutputView {

    public static void printLadder(List<Line> ladder, List<String> names, List<String> results) {
        System.out.println(ConsoleMessage.LADDER_RESULT.getMessage() + "\n");

        names.forEach(name -> System.out.print(name + "  "));
        System.out.println();

        ladder.forEach(line -> printLine(line));

        results.forEach(result -> System.out.print(result + "   "));
        System.out.println();
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

    public static void printResult(String result) {
        System.out.println();
        System.out.println(ConsoleMessage.RESULT.getMessage());
        System.out.println(result);
    }

    public static void printResult(Map<String, String> resultMap) {
        System.out.println();
        System.out.println(ConsoleMessage.RESULT.getMessage());
        resultMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
