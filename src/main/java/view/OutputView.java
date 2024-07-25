package view;

import java.util.stream.Collectors;

import model.Ladder;
import model.Line;
import model.Result;

public class OutputView {
    public void outLadder(Ladder ladder) {
        System.out.println("실행 결과\n");

        for (Line line : ladder.getLines()) {
            System.out.println("\t" + formatLine(line));
        }
    }

    private String formatLine(Line line) {
        return line.getPoints().stream()
            .map(bool -> Boolean.TRUE.equals(bool) ? "-----" : "     ")
            .collect(Collectors.joining("|", "|", "|"));
    }

    public void outResult(Result result) {
        System.out.println();
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%s -> %s%n", i, result.get(String.valueOf(i)));
        }
    }
}
