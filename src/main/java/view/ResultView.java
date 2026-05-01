package view;

import domain.*;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printLadder(Names names, Ladder ladder, List<String> rewards) {
        System.out.println("\n사다리 결과\n");
        names.getValues().forEach(n -> System.out.printf("%6s", n.getName()));
        System.out.println();
        ladder.getLines().forEach(ResultView::printLine);
        rewards.forEach(r -> System.out.printf("%6s", r));
        System.out.println();
    }

    private static void printLine(LadderRow line) {
        String body = line.getPoints().stream()
                .limit(line.getPoints().size() - 1)
                .map(p -> p.isRight() ? "|-----" : "|     ")
                .collect(Collectors.joining());
        System.out.println("    " + body + "|");
    }

    public static void printGameResult(String result) {
        System.out.println("\n실행 결과");
        System.out.println(result);
    }
}
