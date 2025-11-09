package io.suhan.ladder.model.ladder;

import java.util.Collections;
import java.util.List;

public record Line(List<Connection> connections) {
    @Override
    public List<Connection> connections() {
        return Collections.unmodifiableList(connections);
    }
}
