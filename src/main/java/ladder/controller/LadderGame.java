package ladder.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.model.GameSetup;
import ladder.model.Ladder;
import ladder.model.Participants;
import ladder.model.ResultType;
import ladder.model.Results;
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
        GameSetup setup = createGameSetup();
        displayLadder(setup);
        processResult(setup);
    }

    private GameSetup createGameSetup() {
        Participants participants = inputView.inputParticipants();
        List<String> results = inputView.inputResults();
        int height = inputView.inputHeight();
        Ladder ladder = Ladder.create(participants.size(), height);
        return new GameSetup(participants, results, ladder);
    }

    private void displayLadder(GameSetup setup) {
        outputView.printLadder(setup.getLadder(), setup.getParticipants(), setup.getResults());
    }

    private void processResult(GameSetup setup) {
        String result = inputView.inputGameResult();
        Results gameResults = createGameResults(setup);
        printGameResults(result, gameResults);
    }

    private Results createGameResults(GameSetup setup) {
        List<Integer> ladderResults = setup.getLadder().result();
        return new Results(setup.getParticipants(),
            mapResults(setup.getResults(), ladderResults));
    }

    private void printGameResults(String result, Results gameResults) {
        if (ResultType.ALL.equals(ResultType.from(result))) {
            outputView.printAllResults(gameResults);
            return;
        }
        outputView.printSingleResult(gameResults.getResult(result));
    }

    private List<String> mapResults(List<String> inputResults, List<Integer> ladderResults) {
        return IntStream.range(0, inputResults.size())
            .mapToObj(i -> inputResults.get(ladderResults.get(i)))
            .collect(Collectors.toList());
    }
}
