package model;

class TestLineBuilder implements LineBuilder {
    private final Line line;

    TestLineBuilder(Line line) {
        this.line = line;
    }

    @Override
    public Line buildLine(int width) {
        return line;
    }
}