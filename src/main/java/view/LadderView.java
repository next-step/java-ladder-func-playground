package view;

import domain.Ladder;
import domain.Line;

public class LadderView {

    public void print(Ladder ladder) {
        for (Line line : ladder.lines()) {
            System.out.println(line);
        }
    }
}
