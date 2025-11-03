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

    @Test
    void CONNECTED_왼쪽으로_이동한다() {
        //give
        int index = 3;

        //when
        int result = Connect.CONNECTED.moveLeft(index);

        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void CONNECTED_오른쪽으로_이동한다() {
        //give
        int index = 3;

        //when
        int result = Connect.CONNECTED.moveRight(index);

        //then
        assertThat(result).isEqualTo(4);
    }

    @Test
    void DISCONNECTED_제자리이다() {
        //give
        int index = 3;

        //when
        int result1 = Connect.DISCONNECTED.moveRight(index);
        int result2 = Connect.DISCONNECTED.moveLeft(index);

        //then
        assertThat(result1).isEqualTo(3);
        assertThat(result2).isEqualTo(3);
    }
}
