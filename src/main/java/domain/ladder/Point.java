package domain.ladder;

public record Point(
        boolean isConnectRight
) {

    public static Point from(final boolean right) {
        return new Point(right);
    }

    public Point connectNext(final boolean canConnectRight) {
        if (this.isConnectRight) {
            return new Point(false);
        }
        return new Point(canConnectRight);
    }
}
