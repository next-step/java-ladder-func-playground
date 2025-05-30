package view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLadder(List<String> names, List<List<Boolean>> ladderLines, List<String> results) {
        System.out.println("사다리 결과\n");
        printNames(names);
        printLadderStructure(ladderLines);
        printResults(results);
    }

    private void printNames(List<String> names) {
        names.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    private void printLadderStructure(List<List<Boolean>> ladderLines) {
        ladderLines.forEach(this::printLine);
    }

    private void printLine(List<Boolean> steps) {
        System.out.print("    ");
        for (Boolean step : steps) {
            System.out.print(step ? "|-----" : "|     ");
        }
        System.out.println("|");
    }

    private void printResults(List<String> results) {
        results.forEach(result -> System.out.printf("%6s", result));
        System.out.println();
    }

    public void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public void printAllResults(Map<String, String> allResults) {
        System.out.println("실행 결과");
        allResults.forEach((name, result) ->
                System.out.println(name + " : " + result)
        );
    }

    public void printError(String message) {
        System.out.println("오류: " + message);
    }
}
