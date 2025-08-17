package view;

import model.Ladder;
import model.Line;

public class LadderView {

    private final LineView lineView;

    public LadderView(LineView lineView) {
        this.lineView = lineView;
    }

    public void print(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            lineView.print(line);
        }
    }
}
