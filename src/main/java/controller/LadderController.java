package controller;

import domain.Height;
import domain.Result;
import domain.LadderGame;
import service.LadderService;
import domain.Name;
import domain.Names;
import domain.Results;
import view.InputView;
import view.OutputView;
import java.util.Map;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderService ladderService;
    private LadderGame ladderGame;

    public LadderController(InputView inputView, OutputView outputView, LadderService ladderService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderService = ladderService;
    }

    public void start() {
        try {
            String namesInput = inputView.readNames();
            String resultsInput = inputView.readResults();
            int heightInput = inputView.readHeight();

            Names names = ladderService.createNames(namesInput);
            Results results = ladderService.createResults(resultsInput);
            Height height = ladderService.createHeight(heightInput);

            this.ladderGame = ladderService.createLadderGame(names, results, height);

            outputView.printLadder(names, ladderGame.getLadder(), results);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            start();
        }
    }

    public boolean processQuery() {
        try {
            String target = inputView.readNameForResult();

            if (ladderService.isAllQuery(target)) {
                Map<Name, Result> allResults = ladderGame.playAll();
                outputView.printAllResults(allResults);
                return false;
            }

            Name targetName = ladderService.createName(target);
            Result result = ladderGame.play(targetName);
            outputView.printResult(result);
            return true;

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return true;
        }
    }
}
