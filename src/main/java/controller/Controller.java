package controller;

import model.Ladder;
import model.LadderResult;
import util.StringUtil;
import validator.Validator;
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
        int height = inputHeight();


        Ladder ladder = new Ladder(height, width);

        outputView.printLadder(ladder, nameList, targetList);

        LadderResult ladderResult = new LadderResult(width, ladder, nameList, targetList);

        showTarget(ladderResult, nameList);
    }

    private List<String> inputNames() {
        while (true) {
            try {
                String names = inputView.readNames();
                Validator.validateCommaSeparatedFormat(names);
                List<String> nameList = StringUtil.splitByComma(names);
                for (String name : nameList) {
                    Validator.validateSingleName(name);
                }
                return nameList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> inputTargets() {
        String targets = inputView.readTargets();
        Validator.validateCommaSeparatedFormat(targets);
        return StringUtil.splitByComma(targets);
    }

    private int inputHeight() {
        String input = inputView.readHeight();
        Validator.validateInteger(input);
        return Integer.parseInt(input);
    }

    private void showTarget(LadderResult ladderResult, List<String> nameList) {
        for (int i = 0; i < COUNT; i++) {
            String getTarget = inputView.readTargetResult();
            outputView.printTarget(getTarget, ladderResult, nameList);
        }
    }
}
