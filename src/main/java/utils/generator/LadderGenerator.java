package utils.generator;

import domain.Lines;

public class LadderGenerator {
    public static Lines generate(int width, int height) {
        return LineGenerator.generate(width, height);
    }
}
