package io.suhan.ladder.model;

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
        List<String> outcomes = List.of("o1");
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
}
