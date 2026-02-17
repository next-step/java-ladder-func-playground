package domain.ladder;

import java.util.List;

public record Ladder(List<Line> lines) {

    public int getDestination(int startIndex) {
        return lines.stream()
                .reduce(startIndex, (position, line) -> line.move(position),
                        (a, b) -> b);
    }
}
