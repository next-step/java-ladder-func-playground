package strategy;

import domain.ladder.Line;

public interface LineGenerator {
    Line generate(int width);
}
