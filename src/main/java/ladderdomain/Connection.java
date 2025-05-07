package ladderdomain;

public class Connection {

    public final ConnectionStatus connectionStatus;

    public Connection(boolean right) {
        this.connectionStatus = ConnectionStatus.from(right);
    }

    public boolean hasRight() {
        return connectionStatus.isConnected();
    }

}
