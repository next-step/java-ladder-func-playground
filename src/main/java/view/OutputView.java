package view;

import domain.*;
import java.util.Map;

public class OutputView {
    public void printLadder(Names names, Ladder ladder, Results results) {
        System.out.println("사다리 결과\n");
        names.print();
        ladder.print();
        results.print();
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
}
