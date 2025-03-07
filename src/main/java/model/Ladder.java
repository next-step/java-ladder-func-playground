package model;

public class Ladder {
    private final Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(int width, int height) {
        return new Ladder(LadderGenerator.generate(width, height));
    }

    public Lines getLines() {
        return lines;
    }
}
