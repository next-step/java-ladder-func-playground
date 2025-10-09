package io.suhan.ladder.controller;

import io.suhan.ladder.model.Game;
import io.suhan.ladder.model.GameConfiguration;
import io.suhan.ladder.model.GameResult;
import io.suhan.ladder.model.Participant;
import io.suhan.ladder.view.InputView;
import io.suhan.ladder.view.OutputView;
import java.util.List;

public class LadderController {
    public void run() {
        try {
            GameConfiguration configuration = readConfiguration();
            Game game = Game.of(configuration);

            GameResult result = game.execute();

            handleOutcomeQuery(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private GameConfiguration readConfiguration() {
        List<Participant> participants = InputView.getParticipants().stream().map(Participant::new).toList();
        List<String> outcomes = InputView.getOutcomes();
        int height = InputView.getLadderHeight();

        return GameConfiguration.of(participants, outcomes, height);
    }

    private void handleOutcomeQuery(GameResult result) {
        while (true) {
            String input = InputView.getParticipantForResult();

            if (input.equals("all")) {
                OutputView.printGameResult(result);
                break;
            }

            result.getResults().keySet().stream()
                    .filter((participant) -> participant.getName().equals(input))
                    .findFirst()
                    .ifPresentOrElse(
                            (target) -> OutputView.printGameResultOf(target, result),
                            () -> System.out.println("존재하지 않는 참가자입니다.")
                    );
        }
    }
}
