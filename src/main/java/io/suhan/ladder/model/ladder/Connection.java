package io.suhan.ladder.model.ladder;

public class Connection {
    private final int left;
    private final int right;

    public Connection(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
