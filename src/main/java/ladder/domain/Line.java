package ladder.domain;

import java.util.function.BooleanSupplier;

public class Line {

    private final Points points;

    private Line(Points points) {
        this.points = points;
    }

    public static Line generate(int size, BooleanSupplier strategy) {
        return new Line(Points.generate(size, strategy));
    }

    public int move(int index) {
        return points.move(index);
    }

    public Points getPoints() {
        return points;
    }
}
