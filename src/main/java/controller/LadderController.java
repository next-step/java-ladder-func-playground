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
        resultView.printString("실행결과");
        for(Line line : ladder.getLines()){
            resultView.printLadderLine(line.getPoints(), 5);
        }
    }

    public void runLadderResultPrinting(){
        LadderDestinationFinder ladderDestinationFinder = new LadderDestinationFinder(ladder);
        for(int start = 0; start < ladder.getWidth(); start++){
            resultView.printLadderPlayResult(start, ladderDestinationFinder.findDestinationOfLadder(start));
        }
    }
}