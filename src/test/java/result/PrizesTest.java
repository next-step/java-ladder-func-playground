package result;

import model.result.Prize;
import model.result.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizesTest {
    @Test
    @DisplayName("Prizes가 상품 수와 객체를 올바르게 반환한다")
    void prizesCollectionTest() {
        Prize prize1 = new Prize("5000");
        Prize prize2 = new Prize("꽝");
        List<Prize> prizeList = List.of(prize1, prize2);
        Prizes prizes = new Prizes(prizeList);

        assertThat(prizes.size()).isEqualTo(2);

        assertThat(prizes.getPrizeAt(0)).isEqualTo(prize1);
        assertThat(prizes.getPrizeAt(1)).isEqualTo(prize2);

        assertThat(prizes.getPrizes()).containsExactly(prize1, prize2);
    }
}
