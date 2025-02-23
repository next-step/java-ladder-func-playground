package controller;

import domain.*;
import view.*;

public class LadderController {
    private final ResultView resultView = new ResultView();

    public void runLadderPrinting(){
        Ladder ladder = new Ladder();
        for(Line line : ladder.getLines()){
            resultView.printLadderLine(line.getPoints(), 5);
        }
    }
}
