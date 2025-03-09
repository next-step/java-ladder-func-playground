package view;

import java.util.List;

public class ResultView {

    public void printLadder(List<List<Boolean>> ladderChunks) {
        StringBuilder resultBuilder = new StringBuilder();
        printResultHeader();
        appendLadderChunks(ladderChunks, resultBuilder);
        System.out.println(resultBuilder);
    }

    private void appendLadderChunks(List<List<Boolean>> ladderChunks, StringBuilder resultBuilder) {
        for (List<Boolean> chunk : ladderChunks) {
            appendChunkToResult(resultBuilder, chunk);
        }
    }

    private void printResultHeader() {
        System.out.println("실행결과");
        System.out.println();
    }

    private void appendChunkToResult(StringBuilder resultBuilder, List<Boolean> chunk) {
        resultBuilder.append(LineCharacter.VERTICAL.getSymbol());
        appendSymbolsForPoints(chunk, resultBuilder);
        resultBuilder.append("\n");
    }

    private void appendSymbolsForPoints(List<Boolean> points, StringBuilder resultBuilder) {
        for (Boolean isExistPoint : points) {
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
