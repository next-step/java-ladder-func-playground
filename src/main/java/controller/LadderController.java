package controller;

import domain.*;
import view.*;

public class LadderController {
    private final ResultView resultView = new ResultView();
    private final InputView inputView = new InputView();
    private Ladder ladder;

    public void createLadderWithUserInput(){
        ladder = new Ladder(inputView.inputLadderWidthByConsole(), inputView.inputLadderHeightByConsole());
    }

    public void runLadderPrinting(){

        for(Line line : ladder.getLines()){
            resultView.printLadderLine(line.getPoints(), 5);
        }
    }
}
