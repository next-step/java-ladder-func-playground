package controller;

import domain.Ladder;
import view.ResultView;

public class LadderController {

    public void run() {
        Ladder ladder = Ladder.createLadder();
        ResultView.print(ladder);
    }
}
