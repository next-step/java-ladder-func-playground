package domain.dto;

import domain.Line;
import domain.Point;
import java.util.List;

public record ResponseLine(
        List<Boolean> connections
) {

    public static ResponseLine from(final Line line) {
        List<Boolean> connections = line.getPoints().stream()
                .limit(line.getPoints().size() - 1)
                .map(Point::right)
                .toList();
        return new ResponseLine(connections);
    }
}
