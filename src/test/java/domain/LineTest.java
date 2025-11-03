package domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void 하나의_라인에_인접한_두_point가_CONNECTED이면_안된다() {
        //givn
        Random random = new Random(1);
        int playerCount = 3;

        //when
        Line line = Line.create(playerCount, random);

        //then
        for (int i = 0; i < line.getPoints().size() - 1; i++) {
            boolean prev = line.getPoints().get(i).isConnected();
            boolean next = line.getPoints().get(i + 1).isConnected();
            assertThat(prev && next).isFalse();
        }
    }

    @Test
    void 라인_마지막_인덱스면_오른쪽이동불가() {
        //given
        int index = 2;
        Line line = Line.of(List.of(
                Connect.CONNECTED,
                Connect.DISCONNECTED
        ));

        //when
        int result = line.moveOf(index);

        //then
        assertThat(result).isEqualTo(index);
    }

    @Test
    void 라인_처음_인덱스면_왼쪽이동불가() {
        //given
        Line line = Line.of(List.of(
                Connect.DISCONNECTED,
                Connect.CONNECTED
        ));
        int index = 0;

        //when
        int result = line.moveOf(index);

        //then
        assertThat(result).isEqualTo(index);
    }

    @Test
    void 오른쪽은_DISCONNECTED_왼쪽은_CONNECTED면_왼쪽_으로_이동한다() {
        // given
        Line line = Line.of(List.of(
                Connect.DISCONNECTED,
                Connect.CONNECTED
        ));
        int index = 2;

        // when
        int result = line.moveOf(index);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 오른쪽은_CONNECTED_왼쪽은_DISCONNECTED면_오른쪽_으로_이동한다() {
        // given
        Line line = Line.of(List.of(
                Connect.DISCONNECTED,
                Connect.CONNECTED
        ));
        int index = 1;

        // when
        int result = line.moveOf(index);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 양쪽모두_DISCONNECTED면_제자리() {
        //give
        Line line = Line.of(List.of(
                Connect.DISCONNECTED,
                Connect.DISCONNECTED
        ));
        int index = 1;

        //when
        int result = line.moveOf(index);

        //then
        assertThat(result).isEqualTo(index);
    }
}
