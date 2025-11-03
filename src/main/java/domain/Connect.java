package domain;

public enum Connect {
    CONNECTED(true) {
        @Override
        public int moveRight(int index) {
            return index + 1;
        }

        @Override
        public int moveLeft(int index) {
            return index - 1;
        }
    },
    DISCONNECTED(false) {
        @Override
        public int moveRight(int index) {
            return index;
        }

        @Override
        public int moveLeft(int index) {
            return index;
        }
    };

    private final boolean value;

    Connect(boolean value) {
        this.value = value;
    }

    public abstract int moveRight(int index);

    public abstract int moveLeft(int index);

    public boolean isConnected() {
        return value;
    }

    public static Connect from(boolean value) {
        return value ? CONNECTED : DISCONNECTED;
    }
}
