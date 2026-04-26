package model;

import java.util.List;

public record Ladder(List<Line> lineList) {
    @Override
    public String toString() {
        return String.join("\n", this.lineList.stream().map(Line::toString).toList());
    }
}
