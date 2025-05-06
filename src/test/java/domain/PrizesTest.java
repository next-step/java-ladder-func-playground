package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizesTest {

    @Test
    @DisplayName("문자리스트를_받아서_Prizes를_생성한다")
    void 문자리스트를_받아서_Prizes를_생성한다() {
        //given
        List<String> labelList = List.of("1000원", "꽝", "사과", "집");

        //when
        Prizes prizes = Prizes.from(labelList);

        //then
        assertThat(prizes.labels()).containsExactly("1000원", "꽝", "사과", "집");
        assertThat(prizes.labels()).hasSize(4);
    }

    @Test
    @DisplayName("리스트가 null 이면 예외를 반환한다")
    void 리스트가_null_이면_예외를_반환한다() {
        //given
        List<String> labelList = null;

        //then
        assertThatThrownBy(() -> Prizes.from(labelList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상품은 두개 이상이어야 한다")
    void 상품은_두개_이상이어야_한다() {
        //given
        List<String> labelList = List.of();

        //then
        assertThatThrownBy(() -> Prizes.from(labelList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("인덱스로 label을 조횐한다")
    void 인덱스로_label을_조회한다() {
        //when
        Prizes prizes = Prizes.from(List.of("꽝", "집", "건물"));

        //then
        assertThat(prizes.labelAt(1)).isEqualTo("집");
    }

}
