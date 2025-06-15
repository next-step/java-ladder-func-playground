package domain.dto;

import domain.ladder.Line;
import domain.ladder.Point;
import java.util.List;

public record ResponseLine(
        List<Boolean> connections
) {

    public static ResponseLine from(final Line line) {
        List<Boolean> connections = line.getPoints().stream()
                .limit(line.size() - 1)
                .map(Point::isConnectRight)
                .toList();
        return new ResponseLine(connections);
    }
}
