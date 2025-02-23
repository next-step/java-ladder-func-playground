package view;

import static enumurate.LadderElementEnum.*;

import java.util.Map;

import domain.Ladder;
import domain.LadderResult;
import domain.Line;
import enumurate.LadderElementEnum;

public class ResultView {

    public static void outputLines(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL);
        for (Boolean point : line.getPoints()) {
            sb.append(getElement(point));
            sb.append(VERTICAL);
        }
        System.out.println(sb);
    }

    private static LadderElementEnum getElement(Boolean point) {
        if (point) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public static void outputResult(LadderResult ladderResult) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : ladderResult.getResults().entrySet()) {
            sb.append(entry.getKey())
                .append(" -> ")
                .append(entry.getValue())
                .append(System.lineSeparator());
        }
        System.out.println(sb);
    }

}
