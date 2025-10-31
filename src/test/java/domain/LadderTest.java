package domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 높이가_0인_사다리_생성() {
        //given
        Height height = new Height(0);
        int playerCount = 3;

        //when
        Ladder ladder = new Ladder(height, playerCount, new Random(1));

        //then
        assertThat(ladder.getLines()).hasSize(1);
    }

    @Test
    void 높이가_3인_사다리_생성() {
        //given
        Height height = new Height(3);
        int playerCount = 3;

        //when
        Ladder ladder = new Ladder(height, playerCount, new Random(1));

        //then
        assertThat(ladder.getLines()).hasSize(3);
    }
}
