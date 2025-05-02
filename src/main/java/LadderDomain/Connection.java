package LadderDomain;

public class Connection {

    private final ConnectionStatus connectionStatus;

    public Connection(boolean right) {
        this.connectionStatus = ConnectionStatus.from(right);
    }

    public boolean hasRight() {
        return connectionStatus.isConnected();
    }

}
