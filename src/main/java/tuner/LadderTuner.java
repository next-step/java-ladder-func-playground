package tuner;

import ladder.Row;
import ladder.Ladder;
import ladder.Column;

public interface LadderTuner {
    void tune(Ladder ladder, Row rows, Column columns);
}