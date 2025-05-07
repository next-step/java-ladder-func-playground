package ladderdomain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<LadderRow> ladderRows;

    public Ladder(int height, int width) {
        this(height, width, new LadderConnectionGenerator());
    }

    public Ladder(int height, int width, BooleanValueGenerator generator) {
        this.ladderRows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderRows.add(new LadderRow(width, generator));
        }
    }

    public int move(int index) {
        for (LadderRow ladderRow : ladderRows) {
            index = ladderRow.move(index);
        }
        return index;
    }

    public List<LadderRow> getLines() {
        return Collections.unmodifiableList(ladderRows);
    }
}
