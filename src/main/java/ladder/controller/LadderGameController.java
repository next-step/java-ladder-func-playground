package ladder.controller;

import ladder.domain.LadderGameResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    public static void runInquiry(LadderGameResult gameResult) {
        String nameQuery;
        do {
            nameQuery = InputView.inputNameQuery();
            printResult(gameResult, nameQuery);
        } while (!"all".equals(nameQuery));
    }

    private static void printResult(LadderGameResult gameResult, String nameQuery) {
        if ("all".equals(nameQuery)) {
            OutputView.printAllResults(gameResult.getAllResults());
            return;
        }
        try {
            OutputView.printSingleResult(gameResult.getResultByName(nameQuery));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
