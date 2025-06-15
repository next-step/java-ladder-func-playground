package domain.ladder;

public record Point(
        boolean isConnectRight
) {

    public static Point from(final boolean isConnectRight) {
        return new Point(isConnectRight);
    }

    public Point connectNext(final boolean canConnectRight) {
        if (this.isConnectRight) {
            return new Point(false);
        }
        return new Point(canConnectRight);
    }
}
