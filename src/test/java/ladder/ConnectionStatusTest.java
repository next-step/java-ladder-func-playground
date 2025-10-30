package ladder;

import model.ladder.ConnectionStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConnectionStatusTest {
    @Test
    @DisplayName("from(true)는 CONNECTED를 반환한다")
    void fromTrueReturnsConnected() {
        ConnectionStatus status = ConnectionStatus.from(true);

        assertThat(status).isEqualTo(ConnectionStatus.CONNECTED);
    }

    @Test
    @DisplayName("from(false)는 DISCONNECTED를 반환한다")
    void fromFalseReturnsDisconnected() {
        ConnectionStatus status = ConnectionStatus.from(false);

        assertThat(status).isEqualTo(ConnectionStatus.DISCONNECTED);
    }

    @Test
    @DisplayName("CONNECTED의 isConnected()는 true를 반환한다")
    void isConnectedReturnsTrueForConnected() {
        ConnectionStatus status = ConnectionStatus.CONNECTED;

        boolean isConnected = status.isConnected();

        assertThat(isConnected).isTrue();
    }

    @Test
    @DisplayName("DISCONNECTED의 isConnected()는 false를 반환한다")
    void isConnectedReturnsFalseForDisconnected() {
        ConnectionStatus status = ConnectionStatus.DISCONNECTED;

        boolean isConnected = status.isConnected();

        assertThat(isConnected).isFalse();
    }
}
