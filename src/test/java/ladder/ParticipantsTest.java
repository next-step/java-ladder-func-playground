package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import ladder.model.Name;
import ladder.model.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {

    @Test
    @DisplayName("참가자 List<Name>을 통해서 Participants를 생성해야한다.")
    void generateParticipants() {
        List<Name> names = Arrays.asList(
            new Name("pobi"),
            new Name("jason"),
            new Name("brown")
        );
        Participants participants = Participants.of(names);

        assertThat(participants.size()).isEqualTo(3);
        assertThat(participants.getParticipantsNameList().get(0).matches("pobi")).isTrue();
        assertThat(participants.getParticipantsNameList().get(1).matches("jason")).isTrue();
        assertThat(participants.getParticipantsNameList().get(2).matches("brown")).isTrue();

    }
}
