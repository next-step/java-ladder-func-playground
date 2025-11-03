package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultNameTest {
    @Test
    void null은_허용되지_않는다() {
        // when & then
        assertThatThrownBy(() -> new ResultName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈문자열은_허용되지_않는다() {
        // when & then
        assertThatThrownBy(() -> new ResultName("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 정상_이름이면_생성된다() {
        // given
        String name = "태우";

        // when
        ResultName resultName = new ResultName(name);

        // then
        assertThat(resultName.value()).isEqualTo(name);
    }
}
