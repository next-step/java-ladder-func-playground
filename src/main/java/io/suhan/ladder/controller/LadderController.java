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
            List<Participant> participants = InputView.getParticipants().stream().map(Participant::new).toList();
            List<String> outcomes = InputView.getOutcomes();
            int height = InputView.getLadderHeight();

            GameConfiguration configuration = GameConfiguration.of(participants, outcomes, height);

            Game game = Game.of(configuration);

            GameResult result = game.execute();

            while (true) {
                String input = InputView.getParticipantForResult();

                if (input.equals("all")) {
                    OutputView.printGameResult(result);
                    break;
                }

                Participant target = participants.stream()
                        .filter((participant -> participant.getName().equals(input)))
                        .findFirst()
                        .orElse(null);

                if (target != null) {
                    OutputView.printGameResultOf(target, result);
                } else {
                    System.out.println("존재하지 않는 참가자입니다.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
