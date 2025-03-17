package view;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printLadder(List<List<Boolean>> ladderRows, List<String> playerNames, List<String> prize) {
        StringBuilder resultBuilder = new StringBuilder();
        printResultHeader();
        System.out.println(String.join(" ", playerNames));
        appendLadderRows(ladderRows, resultBuilder);
        System.out.println(resultBuilder);
        System.out.println(String.join("  ", prize));
    }

    private void appendLadderRows(List<List<Boolean>> ladderRows, StringBuilder resultBuilder) {
        for (List<Boolean> ladderRow : ladderRows) {
            appendRowToResult(resultBuilder, ladderRow);
        }
    }

    private void printResultHeader() {
        System.out.println("사다리결과");
        System.out.println();
    }

    private void appendRowToResult(StringBuilder resultBuilder, List<Boolean> ladderRow) {
        resultBuilder.append(LineCharacter.VERTICAL.getSymbol());
        appendSymbolsForPoints(ladderRow, resultBuilder);
        resultBuilder.append("\n");
    }

    public void printSingleResult(String prizes) {
        System.out.println("실행결과");
        System.out.println(prizes);
    }

    public void printAllResults(Map<String, String> results) {
        System.out.println("실행결과");
        results.forEach((player, result) ->
                System.out.println(player + ":" + result)
        );
    }

    private void appendSymbolsForPoints(List<Boolean> ladderPoints, StringBuilder resultBuilder) {
        for (Boolean isExistPoint : ladderPoints) {
            if (isExistPoint) {
                resultBuilder.append(LineCharacter.CONNECTED.getSymbol());
            }

            if (!isExistPoint) {
                resultBuilder.append(LineCharacter.DISCONNECTED.getSymbol());
            }
            resultBuilder.append(LineCharacter.VERTICAL.getSymbol());
        }
    }
}
