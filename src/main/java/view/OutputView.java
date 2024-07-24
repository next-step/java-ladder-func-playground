package view;

import java.util.stream.Collectors;

import model.Ladder;
import model.Line;

public class OutputView {
    public void outLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(formatLine(line));
        }
    }

    private String formatLine(Line line) {
        return line.getPoints().stream()
            .map(bool -> Boolean.TRUE.equals(bool) ? "-----" : "     ")
            .collect(Collectors.joining("|", "|", "|"));
    }
}
