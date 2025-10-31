package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConnectTest {
    @Test
    void from메서드_true면_CONNECTED_반환() {
        //when
        Connect value = Connect.from(true);

        //then
        assertThat(value).isEqualTo(Connect.CONNECTED);
    }

    @Test
    void from메서드_true면_DISCONNECTED_반환() {
        //when
        Connect value = Connect.from(false);

        //then
        assertThat(value).isEqualTo(Connect.DISCONNECTED);
    }
}
