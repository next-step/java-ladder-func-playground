package result;

import model.result.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrizeTest {
    @Test
    @DisplayName("유효한 이름으로 상품이 생성된다")
    void createPrizeSuccessfully() {
        String validPrize = "5000";

        Prize prize = new Prize(validPrize);

        assertThat(prize).isNotNull();
        assertThat(prize.getValue()).isEqualTo(validPrize);
    }

    @Test
    @DisplayName("유효하지 않은 상품 생성 시 예외가 발생한다")
    void validatePrizeLength() {
        String invalidPrize = "";

        assertThrows(IllegalArgumentException.class, () -> new Prize(invalidPrize));
    }

    @Test
    @DisplayName("null 상품 생성 시 예외가 발생한다")
    void validatePrizeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Prize(null));
    }
}
