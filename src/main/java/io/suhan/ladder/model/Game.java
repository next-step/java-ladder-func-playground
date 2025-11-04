package io.suhan.ladder.model;

import io.suhan.ladder.model.ladder.Connection;
import io.suhan.ladder.model.ladder.Ladder;
import io.suhan.ladder.model.ladder.LadderFactory;
import io.suhan.ladder.model.ladder.Line;
import io.suhan.ladder.view.OutputView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Game {
    private final Ladder ladder;
    private final GameConfiguration configuration;

    private Game(GameConfiguration configuration, Ladder ladder) {
        this.configuration = configuration;
        this.ladder = ladder;
    }

    public static Game of(GameConfiguration configuration) {
        return new Game(configuration, LadderFactory.createLadder(configuration.width(), configuration.height()));
    }

    public static Game of(GameConfiguration configuration, Ladder ladder) {
        return new Game(configuration, ladder);
    }

    public GameResult execute() {
        List<Participant> participants = configuration.participants();
        List<Outcome> outcomes = configuration.outcomes();
        Map<Participant, Outcome> result = new LinkedHashMap<>();

        OutputView.printLadderResult(this);

        for (int start = 0; start < configuration.width(); start++) {
            int end = traverse(start);
            Participant participant = participants.get(start);
            Outcome outcome = outcomes.get(end);

            result.put(participant, outcome);
        }

        return new GameResult(result);
    }

    private int traverse(int start) {
        int col = start;

        for (Line line : ladder.lines()) {
            col = findNextColumn(line, col);
        }

        return col;
    }

    private int findNextColumn(Line line, int col) {
        Optional<Connection> connected = line.connections().stream()
                .filter((connection) -> connection.left() == col || connection.right() == col)
                .findFirst();

        return connected
                .map((connection) -> getConnectedColumn(connection, col))
                .orElse(col);
    }

    private int getConnectedColumn(Connection connection, int col) {
        if (connection.left() == col) {
            return connection.right();
        }

        return connection.left();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public GameConfiguration getConfiguration() {
        return configuration;
    }
}
