package controller;

import domain.Height;
import domain.Result;
import domain.LadderGame;
import domain.Ladder;
import domain.Line;
import service.LadderService;
import domain.Name;
import domain.Names;
import domain.Results;
import view.InputView;
import view.OutputView;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

            // domain 객체 -> OutputView
            outputView.printLadder(
                    convertNamesToStrings(names),
                    convertLadderToLists(ladderGame.getLadder()),
                    convertResultsToStrings(results)
            );
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
                Map<String, String> convertedResults = convertAllResultsToMap(allResults);
                outputView.printAllResults(convertedResults);
                return false;
            }

            Name targetName = ladderService.createName(target);
            Result result = ladderGame.play(targetName);

            outputView.printResult(result.getValue());
            return true;

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return true;
        }
    }

    private List<String> convertNamesToStrings(Names names) {
        return names.getValues().stream()
                .map(Name::getValue)
                .collect(Collectors.toList());
    }

    private List<List<Boolean>> convertLadderToLists(Ladder ladder) {
        return ladder.getLines().stream()
                .map(Line::getSteps)
                .collect(Collectors.toList());
    }

    private List<String> convertResultsToStrings(Results results) {
        return results.getValues().stream()
                .map(Result::getValue)
                .collect(Collectors.toList());
    }

    private Map<String, String> convertAllResultsToMap(Map<Name, Result> gameResults) {
        return gameResults.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getValue(),
                        entry -> entry.getValue().getValue()
                ));
    }
}
