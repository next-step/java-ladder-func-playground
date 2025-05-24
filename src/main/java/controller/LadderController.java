package controller;

import domain.Ladder;
import domain.Size;
import view.InputView;
import view.LadderView;

public class LadderController {
    public void run() {
        Size size = InputView.readSize();
        Ladder ladder = Ladder.create(size);
        LadderView.printLadder(ladder);
    }
}
