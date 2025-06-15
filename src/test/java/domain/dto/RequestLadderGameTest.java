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
                .hasMessage("플레이어들의 이름은 공백이 아니어야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실행 결과를 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyRunningResults(String runningResults) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadderGame("neo,brown,brie,tommy", runningResults, "5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과는 공백이 아니어야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("사다리의 높이를 입력하지 않았을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyHeight(String height) {
        // given & when & then
        assertThatThrownBy(() -> new RequestLadderGame("neo,brown,brie,tommy", "꽝,5000,꽝,2000", height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 공백이 아니어야 합니다.");
    }

    @Test
    @DisplayName("실행 결과 수와 플레이어 수가 동일하지 않을 경우 예외가 발생한다.")
    void shouldThrowException_whenNotEqualsSize() {
        // given
        String playerNames = "neo,brown,brie,tommy";
        String runningResults = "꽝,5000,꽝";
        RequestLadderGame requestLadderGame = new RequestLadderGame(playerNames, runningResults, "7");

        // when
        Players players = requestLadderGame.toPlayers();

        // then
        assertThatThrownBy(() -> requestLadderGame.toResults(players.size()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과 수는 플레이어 수와 동일해야 합니다.");
    }

    @Test
    @DisplayName("유효한 사다리 게임의 입력 값인 경우 객체가 생성된다.")
    void shouldReturn_whenValidLadderGameValue() {
        // given
        RequestLadderGame requestLadderGame = new RequestLadderGame("neo,brown,brie,tommy", "꽝,5000,꽝,2000", "7");

        // when
        Players players = requestLadderGame.toPlayers();
        Results results = requestLadderGame.toResults(players.size());
        Height height = requestLadderGame.toHeight();

        // then
        assertThat(players.size()).isEqualTo(4);
        assertThat(results.asList().size()).isEqualTo(4);
        assertThat(height.value()).isEqualTo(7);
    }
}
