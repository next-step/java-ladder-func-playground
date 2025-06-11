package domain.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.Height;
import domain.player.Players;
import domain.runningResult.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class RequestLadderGameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("플레이어들의 이름을 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyPlayerNames(String playerNames) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadderGame(playerNames, "꽝,5000,꽝,2000", "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어들의 이름을 입력해야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실행 결과를 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyRunningResults(String runningResults) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadderGame("neo,brown,brie,tommy", runningResults, "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과를 입력해야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사다리의 높이를 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyHeight(String height) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadderGame("neo,brown,brie,tommy", "꽝,5000,꽝,2000", height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이를 입력해야 합니다.");
    }

    @Test
    @DisplayName("유효한 사다리 게임의 입력 값인 경우 객체가 생성된다.")
    void shouldReturn_whenValidLadderGameValue() {
        // given
        RequestLadderGame requestLadderGame = new RequestLadderGame("neo,brown,brie,tommy", "꽝,5000,꽝,2000", "7");

        // when
        Players players = requestLadderGame.toPlayers();
        Results results = requestLadderGame.toResults(players.values().size());
        Height height = requestLadderGame.toHeight();

        // then
        assertThat(players.values().size()).isEqualTo(4);
        assertThat(results.asList().size()).isEqualTo(4);
        assertThat(height.value()).isEqualTo(7);
    }
}
