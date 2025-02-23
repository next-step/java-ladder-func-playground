package view;

import static enumurate.LadderElementEnum.*;

import java.util.List;

import domain.Ladder;
import domain.Line;
import enumurate.LadderElementEnum;

public class ResultView {

    public static void print(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL);
        List<Boolean> points = line.getPoints();
        for (Boolean point : points) {
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
}
