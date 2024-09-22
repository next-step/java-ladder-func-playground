package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @DisplayName("사다리 생성 테스트 4줄일 경우 정상 수행")
    @Test
    public void creationTest() {
        Ladder ladder = new Ladder(4,4);
        assertThat(ladder.getLines().size()).isEqualTo(4);
    }
}
