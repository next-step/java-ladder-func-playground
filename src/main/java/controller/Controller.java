package controller;

import domain.Ladder;
import domain.LadderResult;
import domain.ResultType;
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
        showTarget(ladderResult,nameList);
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
        while(true){
            String input = inputView.readTargetResult();
            if(ContentValidator.validateGetTarget(input,nameList)){
                processTargetResult(input,ladderResult,nameList);
                break;
            }

        }
    }
    private void processTargetResult(String input,LadderResult ladderResult,List<String> nameList){
        ResultType type=ResultType.from(input);
        if(type.isAll()){
            outputView.printTotalResult(ladderResult,nameList);
            return;
        }
        outputView.printTarget(input, ladderResult, nameList);
    }
}
