package controller;

import model.Ladder;
import model.LadderResult;
import view.InputView;
import view.OutputView;

public class Controller {
    private final InputView inputView=new InputView();
    private final OutputView outputView=new OutputView();
    public void run(){
        int width=inputView.getWidth();
        int height=inputView.getHeight();
        Ladder ladder=new Ladder(height,width);
        outputView.printLadder(ladder);

        LadderResult ladderResult=new LadderResult(width,ladder);
        outputView.printLadderResult(ladderResult);
    }
}
