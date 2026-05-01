package testComponents;

import model.Line;
import model.LineBuilder;

public class TestLineBuilder implements LineBuilder {
    private final Line line;

    public TestLineBuilder(Line line) {
        this.line = line;
    }

    @Override
    public Line buildLine(int width) {
        return line;
    }
}
