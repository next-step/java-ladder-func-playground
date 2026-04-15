package controller;

import domain.Ladder;
import generator.RandomConnectionGenerator;
import view.OutputView;

import java.util.ArrayList;

public class LadderController {

    public void run(){
        Ladder ladder = new Ladder(new ArrayList<>());
        ladder.createLadder(new RandomConnectionGenerator());
        OutputView outputView = new OutputView();
        outputView.printLadder(ladder.toBooleanLists());
    }
}
