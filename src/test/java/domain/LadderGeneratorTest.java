package domain;

import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LadderGeneratorTest {
    @Test
    void 빈_공간_발생_시_사다리가_재생성된다() {
        BooleanGenerator customGenerator = new BooleanGenerator() {
            private int callCount = 0;

            @Override
            public boolean generate() {
                callCount++;
                // 폭이 4(간격 3)이고 높이가 2일 때, 1회 생성 시 6번(3 * 2) 호출됨
                // 첫 6번은 false를 반환하여 모든 간격이 빈 상태를 유도
                // 두 번째 시도부터 true를 반환하여 정상 생성
                return callCount > 6;
            }
        };

        Ladder ladder = LadderGenerator.generate(new LadderWidth(4), new LadderHeight(2), customGenerator);

        AssertionsForInterfaceTypes.assertThat(ladder.getLines()).hasSize(2);
        assertThat(ladder.getLines().get(0).isConnectedAt(0)).isTrue();
    }

}