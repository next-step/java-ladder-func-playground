package io.suhan.ladder.model;

import io.suhan.ladder.model.ladder.Ladder;
import io.suhan.ladder.model.ladder.LadderFactory;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(ReplaceUnderscores.class)
public class GameTest {
    @Test
    void 참가자별_결과가_올바르게_매핑된다() {
        // given
        Random fixedRandom = new Random(3L);

        List<Participant> participants = List.of(
                new Participant("p1"),
                new Participant("p2"),
                new Participant("p3"),
                new Participant("p4")
        );

        List<String> outcomes = List.of("o1", "o2", "o3", "o4");
        int height = 4;

        GameConfiguration config = new GameConfigurationBuilder()
                .participants(participants)
                .outcomes(outcomes)
                .height(height)
                .build();

        Ladder ladder = LadderFactory.createLadder(config.getWidth(), config.getHeight(), fixedRandom);

        Game game = Game.of(config, ladder);

        // when
        GameResult result = game.execute();

        // then
        SoftAssertions.assertSoftly((softly) -> {
            softly.assertThat(result.getOutcome(participants.get(0))).isEqualTo("o1");
            softly.assertThat(result.getOutcome(participants.get(1))).isEqualTo("o2");
            softly.assertThat(result.getOutcome(participants.get(2))).isEqualTo("o3");
            softly.assertThat(result.getOutcome(participants.get(3))).isEqualTo("o4");
        });
    }
}
