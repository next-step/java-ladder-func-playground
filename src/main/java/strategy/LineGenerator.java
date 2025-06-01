package strategy;

import domain.Line;

public interface LineGenerator {
    Line generate(int width);
}
