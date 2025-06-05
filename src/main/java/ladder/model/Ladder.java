package ladder.model;

import java.util.List;

public class Ladder {
    private List<List<Boolean>> lines;

    public Ladder(List<List<Boolean>> lines) {
        this.lines = List.copyOf(lines);
    }

    public List<List<Boolean>> getLines() {
        return List.copyOf(lines);
    }

}
