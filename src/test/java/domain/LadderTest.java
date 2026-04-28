package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("제어된 제너레이터를 통해 빈 공간 발생 시 사다리가 재생성되는지 검증한다.")
    void generateAndRetryWhenEmptyInterval() {
        BooleanGenerator customGenerator = new BooleanGenerator() {
            private int callCount = 0;

            @Override
            public boolean generate() {
                callCount++;
                // 3간격 * 2높이 = 6번 호출됨
                // 첫 번째 시도(callCount <= 6)는 모두 false 반환 -> 공백 사다리 발생 조건
                // 두 번째 시도부터 true를 섞어 반환 -> 정상 사다리 생성
                return callCount > 6;
            }
        };

        Ladder ladder = Ladder.generate(new LadderWidth(3), new LadderHeight(2), customGenerator);

        // 높이가 2인 사다리가 정상적으로 반환되었는지 검증
        assertThat(ladder.getLines()).hasSize(2);

        // 재시도 로직을 거쳐 새롭게 생성된(true가 포함된) 라인인지 확인
        assertThat(ladder.getLines().get(0).isConnectedAt(0)).isTrue();
    }
}