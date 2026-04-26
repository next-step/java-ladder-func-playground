package controller;

import model.Ladder;
import model.LadderResult;
import util.StringUtil;
import validator.ContentValidator;
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

        LadderResult ladderResult = new LadderResult(ladder, nameList, targetList);

        showTarget(ladderResult, nameList);
    }

    private List<String> inputNames() {
        while(true){
            String names=inputView.readNames();
            List<String> nameList=StringUtil.splitByComma(names);
            if(ContentValidator.validateNameList(nameList)){
                return nameList;
            }
        }
    }

    private List<String> inputTargets() {
        String targets = inputView.readTargets();
        return StringUtil.splitByComma(targets);
    }

    private int inputHeight() {
        String input = inputView.readHeight();
        return Integer.parseInt(input);
    }

    private void showTarget(LadderResult ladderResult, List<String> nameList) {
        for (int i = 0; i < COUNT; i++) {
            while(true){
                String input = inputView.readTargetResult();
                if(ContentValidator.validateGetTarget(input,nameList)){
                    outputView.printTarget(input, ladderResult, nameList);
                    break;
                }
                System.out.println("ERROR: 결과를 보고 싶은 사람을 제대로 입력하세요.");
            }

        }
    }
}
