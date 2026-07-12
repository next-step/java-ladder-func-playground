package view;

import domain.LadderGame;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final int SPACE_WIDTH = 6;
    private final LadderPrinter ladderPrinter = new LadderPrinter();

    public void printLadder(List<String> playerNames, LadderGame ladderGame, List<String> resultItems) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();

        printNames(playerNames);
        ladderPrinter.printLadder(ladderGame);
        printNames(resultItems);
    }

    private void printNames(List<String> names) {
        for (String name : names) {
            System.out.print(String.format("%-" + SPACE_WIDTH + "s", name));
        }
        System.out.println();
    }

    public void printSingleResult(String player, String resultItem) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(player + " : " + resultItem);
    }

    public void printAllResults(Map<String, String> ladderGameResult) {
        System.out.println();
        System.out.println("실행 결과");

        ladderGameResult.forEach((player, result) ->
                System.out.println(player + " : " + result)
        );
    }
}
