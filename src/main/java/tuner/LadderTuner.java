package tuner;

import ladder.Height;
import ladder.Ladder;
import ladder.Line;
import ladder.Width;

import java.util.List;

public interface LadderTuner {
    void tune(Ladder ladder, Height height, Width width);
}