package controller;

import model.Ladder;
import model.LadderResult;
import util.StringUtil;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        String names = inputView.readNames();
        String targets = inputView.readTargets();

        List<String> nameList = StringUtil.splitByComma(names);
        List<String> targetList = StringUtil.splitByComma(targets);

        int width = nameList.size() - 1;
        int height = inputView.readHeight();


        Ladder ladder = new Ladder(height, width);
        outputView.printLadder(ladder, nameList, targetList);

        LadderResult ladderResult = new LadderResult(width, ladder, nameList, targetList);

        String getTarget1 = inputView.readTargetResult();

        outputView.printTarget(getTarget1, ladderResult, nameList);

        String getTarget2 = inputView.readTargetResult();

        outputView.printTarget(getTarget2, ladderResult, nameList);
    }
}
