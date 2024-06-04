package model;

public class Line {

    private final boolean hasPedal;

<<<<<<< HEAD
=======
    private Line(boolean hasPedal) {
        this.hasPedal = hasPedal;
    }

>>>>>>> 0c46fef (Feat:)
    public static Line of(boolean hasPoint) {
        return new Line(hasPoint);
    }

    public boolean hasPedal() {
        return hasPedal;
    }
<<<<<<< HEAD

    private Line(boolean hasPedal) {
        this.hasPedal = hasPedal;
    }
=======
>>>>>>> 0c46fef (Feat:)
}
