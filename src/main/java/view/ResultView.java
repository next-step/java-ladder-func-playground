package view;

import java.util.List;

public class ResultView {

    public void printLadder(List<String> ladderLines) {
        printResultHeader();
        StringBuilder resultBuilder = new StringBuilder();
        processLadderLines(resultBuilder, ladderLines);
        outputResult(resultBuilder);
    }

    private void printResultHeader() {
        System.out.println("실행결과");
        System.out.println();
    }

    private void processLadderLines(StringBuilder resultBuilder, List<String> ladderLines) {
        for (String line : ladderLines) {
            String[] points = parseLine(line);
            resultBuilder.append(LineCharacter.VERTICAL.getSymbol());
            appendSymbolsForPoints(points, resultBuilder);
            resultBuilder.append("\n");
        }
    }

    private String[] parseLine(String line) {
        return line.replaceAll("[\\[\\] ]", "").split(",");
    }

    private void appendSymbolsForPoints(String[] points, StringBuilder resultBuilder) {
        for (String point : points) {
            appendSymbolToBuilder(resultBuilder, point);
            resultBuilder.append(LineCharacter.VERTICAL.getSymbol());
        }
    }

    private void appendSymbolToBuilder(StringBuilder resultBuilder, String point) {
        if (point.equals("HAS_POINT")) {
            resultBuilder.append(LineCharacter.CONNECTED.getSymbol());
        } else if (point.equals("NO_POINT")) {
            resultBuilder.append(LineCharacter.DISCONNECTED.getSymbol());
        }
    }

    private void outputResult(StringBuilder resultBuilder) {
        System.out.println(resultBuilder);
    }
}
