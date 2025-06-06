package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import ladder.model.Name;
import ladder.model.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {

    @Test
    @DisplayName("참가자 생성")
    void generateParticipants() {
        Participants participants = Participants.from("pobi,jason,brown");
        List<Name> names = participants.values();

        assertThat(participants.size()).isEqualTo(3);
        assertThat(names.get(0).matches("pobi")).isTrue();
        assertThat(names.get(1).matches("jason")).isTrue();
        assertThat(names.get(2).matches("brown")).isTrue();
    }
}
