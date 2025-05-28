package domain;

public record Point(
        boolean right
) {

    public static Point first(final boolean right) {
        return new Point(right);
    }

    public Point connectNext(final boolean canConnectRight) {
        if (this.right) {
            return new Point(false);
        }
        return new Point(canConnectRight);
    }
}
