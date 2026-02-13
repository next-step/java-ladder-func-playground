package domain.ladder;

import java.util.List;

public record Ladder(List<Line> lines) {

    public int getDestination(int startIndex) {
        int position = startIndex;

        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }
}
