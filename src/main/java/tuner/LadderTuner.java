package tuner;

import ladder.Line;
import ladder.Width;

import java.util.List;

public interface LadderTuner {
    void tune(List<Line> lines, Width width);
}