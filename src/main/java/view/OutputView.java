package view;

import domain.Ladder;
import domain.Line;

public class OutputView {

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            String lineString = line.toLine();
            System.out.println(lineString);
        }
    }
}
