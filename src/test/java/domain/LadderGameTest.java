package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static domain.Line.*;

class LadderGameTest {

    @Test
    @DisplayName("플레이어 수와 상품 수가 다르면 예외를 던진다")
    void 플레이어_수와_상품_수가_다르면_예외를_던진다() {
        Players players = Players.from(List.of("A", "B"));
        Prizes prizes = Prizes.from(List.of("TV"));

        Assertions.assertThatThrownBy(() -> LadderGame.create(null, players, prizes)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 수와 상품의 수는 같아야 합니다.");
    }

    @Test
    @DisplayName("ladder가_null이면_예외를_던진다")
    void ladder가_null이면_예외를_던진다() {
        Players players = Players.from(List.of("A", "B"));
        Prizes prizes = Prizes.from(List.of("TV", "돈"));

        Assertions.assertThatThrownBy(() -> LadderGame.create(null, players, prizes)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리를 넘겨주세요.");
    }

    @Test
    @DisplayName("정상적으로 사다리 게임이 동작하여 결과를 매핑한다")
    void 사다리_게임_정상_동작() {
        // given
        Players players = Players.from(List.of("A", "B", "C", "D"));
        Prizes prizes = Prizes.from(List.of("TV", "집", "차", "돈"));

        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(
                CONNECTED, NOT_CONNECTED, CONNECTED,        //   |-----|     |-----|
                NOT_CONNECTED, CONNECTED, NOT_CONNECTED,    //   |     |-----|     |
                NOT_CONNECTED, CONNECTED, NOT_CONNECTED     //   |     |-----|     |
        );
        Ladder ladder = Ladder.create(fixedBooleanGenerator, new LadderHeight(3), players);
        LadderGame game = LadderGame.create(ladder, players, prizes);

        // when
        LadderResult ladderResult= game.play();

        // then
        Assertions.assertThat(ladderResult.all()).containsExactlyInAnyOrderEntriesOf(Map.of(
                "A", "집",
                "B", "TV",
                "C", "돈",
                "D", "차"
        ));
    }
}
