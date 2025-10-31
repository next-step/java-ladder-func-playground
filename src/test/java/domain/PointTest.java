package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void 생성한_point가_Connect와_같은지_확인() {
        //given
        Connect connect = Connect.CONNECTED;

        //when
        Point point = new Point(connect);

        //then
        assertThat(point.point()).isEqualTo(connect);
    }
}
