package view;

import domain.Ladder;
import domain.Line;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String DELIMITER = "|";
    private static final String CONNECT_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final int NAME_WIDTH = 5;

    public void printResult(Ladder ladder, List<String> inputs, List<String> outputs) {
        System.out.println("\n사다리 결과\n");
        printList(inputs);
        printLines(ladder);
        printList(outputs);
    }

    public void printTotalTarget(Map<String, String> targets) {
        System.out.println("\n실행결과");
        String formattedResult = targets.entrySet().stream()
                .map(entry -> String.format(
                        "%s : %s", entry.getKey(), entry.getValue()
                ))
                .collect(Collectors.joining("\n"));

        System.out.println(formattedResult);
    }

    public void printTarget(String target) {
        System.out.println("\n실행결과");
        System.out.println(target);
    }

    public void printTargetName() {
        System.out.println("\n결과를 보고 싶은 사람은?");
    }

    public void printPlayerNameGuide() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printPrizeNameGuide() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printHeightGuide() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");

    }

    public void printErrorMessage(String message) {
        System.out.println("[ERROR]" + message);
    }

    private void printLines(Ladder ladder) {
        String result = ladder.getLines().stream()
                .map(this::hasLine)
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }

    private void printList(List<String> stringList) {
        for (String string : stringList) {
            System.out.printf("%" + NAME_WIDTH + "s ", string);
        }
        System.out.println();
    }

    private String hasLine(Line line) {
        return line.getPoints().stream()
                .map(hasPoint -> hasPoint ? CONNECT_LINE : EMPTY_LINE)
                .collect(Collectors.joining(DELIMITER, "    " + DELIMITER, DELIMITER));
    }
}
