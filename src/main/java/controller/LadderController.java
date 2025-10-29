package controller;

import domain.Ladder;
import domain.LadderBuilder;
import generator.LadderGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {
    private final LadderGenerator ladderGenerator;
    private final LadderBuilder ladderBuilder;
    private final OutputView outputView;
    private final InputView inputView;

    public LadderController(LadderGenerator ladderGenerator, LadderBuilder ladderBuilder, OutputView outputView , InputView inputView) {
        this.ladderGenerator = new LadderGenerator();
        this.ladderBuilder = new LadderBuilder();
        this.outputView = new OutputView();
        this.inputView = inputView;
    }

    public void run(){
        int colCount = getCol();
        int rowCount = getRow();
        Ladder ladder = ladderGenerator.generateLadder(colCount,rowCount);
        List<String> ladderString = ladderBuilder.buildLadder(ladder);
        outputView.printLadder(ladderString);
    }

    public int getCol() {
        outputView.printColInput();
        return inputView.getInputCol();
    }

    public int getRow() {
        outputView.printRowInput();
        return inputView.getInputRow();
    }
}
