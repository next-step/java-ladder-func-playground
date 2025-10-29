package controller;

import domain.Ladder;
import domain.LadderBuilder;
import domain.LadderGenerator;
import view.OutputView;

import java.util.List;

public class LadderController {
    private final LadderGenerator ladderGenerator;
    private final LadderBuilder ladderBuilder;
    private final OutputView outputView;

    public LadderController(LadderGenerator ladderGenerator, LadderBuilder ladderBuilder, OutputView outputView) {
        this.ladderGenerator = new LadderGenerator();
        this.ladderBuilder = new LadderBuilder();
        this.outputView = new OutputView();
    }

    public void run(){
        Ladder ladder = ladderGenerator.generateLadder(4,4);
        List<String> ladderString = ladderBuilder.buildLadder(ladder);
        outputView.printLadder(ladderString);
    }
}
