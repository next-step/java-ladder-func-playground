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

    int COUNT = 2;

    public void run() {
        List<String> nameList = inputNames();
        List<String> targetList = inputTargets();

        int width = nameList.size() - 1;
        int height = inputView.readHeight();

        Ladder ladder = new Ladder(height, width);

        outputView.printLadder(ladder, nameList, targetList);

        LadderResult ladderResult = new LadderResult(width, ladder, nameList, targetList);

        showTarget(ladderResult, nameList);
    }

    private List<String> inputNames() {
        String names = inputView.readNames();
        return StringUtil.splitByComma(names);
    }

    private List<String> inputTargets() {
        String targets = inputView.readTargets();
        return StringUtil.splitByComma(targets);
    }

    private void showTarget(LadderResult ladderResult, List<String> nameList) {
        for (int i = 0; i < COUNT; i++) {
            String getTarget = inputView.readTargetResult();
            outputView.printTarget(getTarget, ladderResult, nameList);
        }
    }
}
