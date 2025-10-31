package domain;

public enum Connect {
    CONNECTED(true),
    DISCONNECTED(false);

    private final boolean value;

    Connect(boolean value){
        this.value = value;
    }

    public boolean isConnected(){
        return value;
    }

    public static  Connect from(boolean value){
        return value ? CONNECTED : DISCONNECTED;
    }
}
