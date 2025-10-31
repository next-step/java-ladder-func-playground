package domain;

import org.junit.jupiter.api.Test;

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
            boolean prev = line.getPoints().get(i).point().isConnected();
            boolean next = line.getPoints().get(i + 1).point().isConnected();
            assertThat(prev && next).isFalse();
        }
    }

    @Test
    void 사다리가_맨끝인_경우_DISCONNECTED이다() {
        //given
        int index = 3;
        Line line = Line.create(4, new Random(1));

        //when
        Connect result = line.validateMoveRight(index);

        //then
        assertThat(result).isEqualTo(Connect.DISCONNECTED);
    }

    @Test
    void 사다리가_처음인_경우_DISCONNECTED이다() {
        //given
        int index = 0;
        Line line = Line.create(4, new Random(1));

        //when
        Connect result = line.validateMoveLeft(index);

        //then
        assertThat(result).isEqualTo(Connect.DISCONNECTED);
    }
}
