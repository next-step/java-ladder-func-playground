package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantsTest {

    @DisplayName("2명 이상의 중복되지 않은 이름 리스트로 참가자 명단을 생성할 수 있다.")
    @Test
    void create_Success() {
        // given
        List<String> names = List.of("pobi", "honux", "crong");

        // when
        Participants participants = Participants.from(names);

        // then
        assertThat(participants.size()).isEqualTo(3);
        assertThat(participants.getValues())
            .extracting(Name::getName)
            .containsExactly("pobi", "honux", "crong");
    }

    @DisplayName("참여 인원이 2명 미만이면 예외가 발생한다.")
    @Test
    void validate_Size_Exception() {
        // given
        List<String> names = List.of("pobi");

        // then
        assertThatThrownBy(() -> Participants.from(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("참여할 사람은 최소 2명 이상이어야 합니다.");
    }

    @DisplayName("참가자 이름 중에 중복이 있으면 예외가 발생한다.")
    @Test
    void validate_Duplicate_Exception() {
        // given
        List<String> names = List.of("pobi", "pobi", "honux");

        // then
        assertThatThrownBy(() -> Participants.from(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 중복될 수 없습니다.");
    }

}
