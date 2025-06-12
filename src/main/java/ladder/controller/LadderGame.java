package ladder.controller;

import java.util.List;
import java.util.stream.Collectors;
import ladder.model.Ladder;
import ladder.model.LadderResult;
import ladder.model.Participants;
import ladder.model.Point;
import ladder.model.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Participants participants = inputView.inputParticipants();
        List<Result> results = inputView.inputResults();
        int height = inputView.inputHeight();

        Ladder ladder = Ladder.create(participants.size(), height);
        outputView.printLadder(ladder, participants, results);

        String resultRequest = inputView.inputGameResult();
        processResult(ladder, participants, results, resultRequest);
    }

    private void processResult(Ladder ladder, Participants participants, List<Result> results,
        String resultRequest) {
        List<Point> ladderResults = ladder.result();
        List<Result> mappedResults = mapResults(results, ladderResults);
        LadderResult ladderResult = new LadderResult(participants, mappedResults);
        printGameResults(resultRequest, ladderResult);
    }

    private void printGameResults(String result, LadderResult gameLadderResult) {
        if ("all".equals(result)) {
            outputView.printAllResults(gameLadderResult);
            return;
        }
        outputView.printSingleResult(gameLadderResult.getResult(result));
    }

    private List<Result> mapResults(List<Result> inputResults, List<Point> ladderResults) {
        return ladderResults.stream()
            .map(point -> inputResults.get(point.getEnd()))
            .collect(Collectors.toList());
    }
}
