package view;

import domain.Ladder;
import domain.LadderResult;
import domain.Line;

import java.util.List;


public class OutputView {

    public void printLadder(Ladder ladder, List<String> nameList, List<String> targetList) {
        System.out.println("\n사다리결과");
        printNames(nameList);
        for (Line line : ladder.getLadder()) {
            printLine(line);
        }
        printTargets(targetList);
    }

    public void printNames(List<String> nameList) {
        for (String name : nameList) {
            System.out.printf("%-6s", name);
        }
        System.out.println();
    }

    public void printTargets(List<String> targetList) {
        for (String target : targetList) {
            System.out.printf("%-6s", target);
        }
        System.out.println();
    }

    public void printLine(Line line) {
        System.out.print("ㅣ");
        for (int i = 0; i < line.getWidth();i++) {
            if(line.getLine().get(i)){
                System.out.print("-----ㅣ");
                continue;
            }
            System.out.println("     ㅣ");
        }
        System.out.println(" ");
    }

    public void printTarget(String input, LadderResult ladderResult, List<String> names) {
        if (input.equals("all")) {
            printTotalResult(ladderResult, names);
        } else {
            System.out.println("\n실행 결과");
            System.out.println(ladderResult.getTargetLadderResult(input.trim()));
        }
    }

    public void printTotalResult(LadderResult ladderResult, List<String> names) {
        System.out.println("\n실행 결과");
        for (String name : names) {
            System.out.println(name + " : " + ladderResult.getTargetLadderResult(name));
        }
    }
}
