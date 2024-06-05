package model;

import org.junit.jupiter.api.Test;

class GenerateLaddersTest {

    @Test
    void 사다리_생성_테스트() {
        // given
        GenerateLadders generateLadders = new GenerateLadders();
        // when
        generateLadders.generate(3,4);
        // then
    }

}