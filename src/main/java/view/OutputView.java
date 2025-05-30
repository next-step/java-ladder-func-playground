package view;

import domain.Results;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Line;
import domain.Result;
import java.util.Map;

public class OutputView {
    public void printLadder(Names names, Ladder ladder, Results results) {
        System.out.println("사다리 결과\n");
        printNames(names);
        printLadderStructure(ladder);
        printResults(results);
    }

    private void printNames(Names names) {
        names.getValues().forEach(name -> System.out.printf("%6s", name.getValue()));
        System.out.println();
    }

    private void printLadderStructure(Ladder ladder) {
        ladder.getLines().forEach(this::printLine);
    }

    private void printLine(Line line) {
        System.out.print("    ");
        for (Boolean step : line.getSteps()) {
            System.out.print(step ? "|-----" : "|     ");
        }
        System.out.println("|");
    }

    private void printResults(Results results) {
        results.getValues().forEach(result -> System.out.printf("%6s", result.getValue()));
        System.out.println();
    }

    public void printResult(Result result) {
        System.out.println("실행 결과");
        System.out.println(result.getValue());
    }

    public void printAllResults(Map<Name, Result> allResults) {
        System.out.println("실행 결과");
        allResults.forEach((name, result) ->
                System.out.println(name.getValue() + " : " + result.getValue())
        );
    }

    public void printError(String message) {
        System.out.println("오류: " + message);
    }
}
