package view;

import domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void outputPlayers(Players players) {
        List<String> names = players.names();
        for (String name : names) {
            outputPlayerName(name);
        }
        System.out.println();
    }

    private void outputPlayerName(String name) {
        System.out.printf("%-6s", name);
    }

    public void outputLadder(Ladder ladder) {
        LadderPrinter.outputLadder(ladder);
    }

    public void outputLadderHeader() {
        System.out.println("사다리 결과");
    }

    public void outputResultNames(Prizes prizes) {
        List<String> resultedNames = prizes.labels();
        for (String resultedName : resultedNames) {
            outputResultName(resultedName);
        }
        System.out.println();
    }

    private void outputResultName(String resultedName) {
        System.out.printf("%-6s", resultedName);
    }

    public void outputResultByName(String s) {
        printResultTitle();
        System.out.println(s);
    }

    private void printResultTitle() {
        System.out.println("실행 결과");
    }

    public void outputAllResult(Map<String, String> result) {
        printResultTitle();
        result.forEach((name, prize) -> System.out.println(name + " : " + prize));
    }
}
