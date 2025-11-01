package io.suhan.ladder.controller;

import io.suhan.ladder.model.Game;
import io.suhan.ladder.model.GameConfiguration;
import io.suhan.ladder.model.GameConfigurationBuilder;
import io.suhan.ladder.model.GameResult;
import io.suhan.ladder.model.Participant;
import io.suhan.ladder.view.InputView;
import io.suhan.ladder.view.OutputView;
import java.util.List;
import java.util.stream.Stream;

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
        // method chaining으로 구성하려고 하였으나 Input 검증으로 인해 각각 따로 받음
        GameConfigurationBuilder builder = new GameConfigurationBuilder();

        List<Participant> participants = InputView.getParticipants().stream().map(Participant::new).toList();
        builder.participants(participants);

        List<String> outcomes = InputView.getOutcomes();
        builder.outcomes(outcomes);

        int height = InputView.getLadderHeight();
        builder.height(height);

        return builder.build();
    }

    private void handleOutcomeQuery(GameResult result) {
        Stream.generate(InputView::getParticipantForResult)
                .takeWhile((input) -> !input.equals("all"))
                .forEach((input) -> result.results().keySet().stream()
                        .filter((participant) -> participant.name().equals(input))
                        .findFirst()
                        .ifPresentOrElse(
                                (target) -> OutputView.printGameResultOf(target, result),
                                () -> System.out.println("존재하지 않는 참가자입니다.")
                        )
                );

        OutputView.printGameResult(result);
    }
}
