package ladder;

import java.util.Map;
import java.util.Random;
import ladder.controller.LadderGameController;
import ladder.domain.Ladder;
import ladder.domain.LadderGameResult;
import ladder.domain.LadderHeight;
import ladder.domain.LadderResults;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Participants participants = InputView.inputNames();
        LadderResults results = InputView.inputLadderResults(participants.size());

        LadderHeight height = InputView.inputHeight();

        Ladder ladder = Ladder.of(participants, height, RANDOM::nextBoolean);

        Map<Integer, Integer> path = ladder.generateResults();

        LadderGameResult gameResult = LadderGameResult.of(participants, results, path);

        OutputView.printLadder(participants, ladder, results);
        LadderGameController.runInquiry(gameResult);

    }

}
