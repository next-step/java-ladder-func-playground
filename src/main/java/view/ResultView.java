package view;

import java.util.List;

public class ResultView {

    public void printLadder(List<List<Boolean>> ladderRows) {
        StringBuilder resultBuilder = new StringBuilder();
        printResultHeader();
        appendLadderRows(ladderRows, resultBuilder);
        System.out.println(resultBuilder);
    }

    private void appendLadderRows(List<List<Boolean>> ladderRows, StringBuilder resultBuilder) {
        for (List<Boolean> ladderRow : ladderRows) {
            appendRowToResult(resultBuilder, ladderRow);
        }
    }

    private void printResultHeader() {
        System.out.println("실행결과");
        System.out.println();
    }

    private void appendRowToResult(StringBuilder resultBuilder, List<Boolean> ladderRow) {
        resultBuilder.append(LineCharacter.VERTICAL.getSymbol());
        appendSymbolsForPoints(ladderRow, resultBuilder);
        resultBuilder.append("\n");
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
