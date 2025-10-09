package io.suhan.ladder.model;

import io.suhan.ladder.model.ladder.Connection;
import io.suhan.ladder.model.ladder.Ladder;
import io.suhan.ladder.model.ladder.LadderFactory;
import io.suhan.ladder.model.ladder.Line;
import io.suhan.ladder.view.OutputView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private final Ladder ladder;
    private final GameConfiguration configuration;

    private Game(GameConfiguration configuration) {
        this.ladder = LadderFactory.createLadder(configuration.getWidth(), configuration.getHeight());
        this.configuration = configuration;
    }

    public static Game of(GameConfiguration configuration) {
        return new Game(configuration);
    }

    public GameResult execute() {
        List<Participant> participants = configuration.getParticipants();
        List<String> outcomes = configuration.getOutcomes();
        Map<Participant, String> result = new LinkedHashMap<>();

        OutputView.printLadder(this);

        for (int start = 0; start < configuration.getWidth(); start++) {
            int end = traverse(start);
            Participant participant = participants.get(start);
            String outcome = outcomes.get(end);

            result.put(participant, outcome);
        }

        return new GameResult(result);
    }

    private int traverse(int start) {
        int col = start;

        for (Line line : ladder.getLines()) {
            col = findNextColumn(line, col);
        }

        return col;
    }

    private int findNextColumn(Line line, int col) {
        return line.getConnections().stream()
                .filter((connection) -> connection.getLeft() == col || connection.getRight() == col)
                .findFirst()
                .map((connection) -> getConnectedColumn(connection, col))
                .orElse(col);
    }

    private int getConnectedColumn(Connection connection, int col) {
        if (connection.getLeft() == col) {
            return connection.getRight();
        }

        return connection.getLeft();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public GameConfiguration getConfiguration() {
        return configuration;
    }
}
