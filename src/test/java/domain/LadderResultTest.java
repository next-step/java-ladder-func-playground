package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class LadderResultTest {

    @Test
    @DisplayName("정상적인 맵이 주어지면 정상적인 객체가 생성된다")
    void 정상적인_맵이_주어지면_정상적인_객체가_생성된다() {
        //given
        Map<String, String> map = new HashMap<>();
        map.put("A", "상품1");
        map.put("B", "상품2");

        //when
        LadderResult ladderResult = LadderResult.create(map);

        //then
        Assertions.assertThat(ladderResult.prizeOf("A")).isEqualTo("상품1");
        Assertions.assertThat(ladderResult.prizeOf("B")).isEqualTo("상품2");
    }

    @Test
    @DisplayName("결과 맵이 null이면 예외를 던진다")
    void 결과_맵이_null이면_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> LadderResult.create(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과 맵에 null 키가 있으면 예외 발생")
    void null_키_예외() {
        //given
        Map<String, String> map = new HashMap<>();
        map.put("A", "상품1");
        map.put("B", null);
        map.put("C", "상품3");

        Assertions.assertThatThrownBy(() -> LadderResult.create(map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("존재하지 않는 플레이어 이름으로 prizeOf를 호출하면 예외를 던진다")
    void 존재하지_않는_플레이어_이름으로_prizeOf를_호출하면_예외를_던진다() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("A", "TV");

        LadderResult result = LadderResult.create(resultMap);

        Assertions.assertThatThrownBy(() -> result.prizeOf("없는사람"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 플레이어입니다.");
    }

    @Test
    @DisplayName("모든 결과를 불변 맵으로 반환한다")
    void 모든_결과를_불변_맵으로_반환한다() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "TV");
        map.put("B", "집");
        LadderResult result = LadderResult.create(map);

        Map<String, String> all = result.all();
        Assertions.assertThat(all).containsEntry("A", "TV");
        Assertions.assertThat(all).containsEntry("B", "집");
        Assertions.assertThat(all).hasSize(2);

        Assertions.assertThatThrownBy(() -> all.put("C", "차"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
