package io.suhan.ladder.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class GameConfigurationBuilderTest {
    @Test
    void GameConfiguration을_올바르게_생성할_수_있다() {
        // given
        List<Participant> participants = List.of(new Participant("p1"));
        List<Outcome> outcomes = List.of(new Outcome("o1"));
        int height = 1;

        // when
        GameConfiguration config = new GameConfigurationBuilder()
                .participants(participants)
                .outcomes(outcomes)
                .height(height)
                .build();

        // then
        SoftAssertions.assertSoftly((softly) -> {
            softly.assertThat(config.participants()).isEqualTo(participants);
            softly.assertThat(config.outcomes()).isEqualTo(outcomes);
            softly.assertThat(config.height()).isEqualTo(height);
        });
    }

    @Test
    void 참가자의_수와_실행_결과의_수는_같아야_한다() {
        // given
        List<Participant> participants = List.of(new Participant("p1"));
        List<Outcome> outcomes = List.of(new Outcome("o1"), new Outcome("o2"));
        int height = 1;
        String expectedMessage = "참가자의 수와 실행 결과의 수는 같아야 합니다.";

        // when & then
        assertThatThrownBy(() -> new GameConfigurationBuilder()
                .participants(participants)
                .outcomes(outcomes)
                .height(height)
                .build()).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}
