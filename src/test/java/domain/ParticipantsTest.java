package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantsTest {

    @Test
    @DisplayName("참가자가 없을 경우 예외 발생")
    void throwsIfEmptyParticipants() {
        List<String> empty = List.of();
        assertThrows(IllegalArgumentException.class, () ->
                Participants.of(empty));
    }

    @Test
    @DisplayName("이름이 5자를 초과할 경우 예외 발생")
    void throwsIfNameTooLong() {
        List<String> names = List.of("toolongname");
        assertThrows(IllegalArgumentException.class, () ->
                Participants.of(names));
    }

    @Test
    @DisplayName("이름으로 예약어 'all'이 포함되면 예외 발생")
    void throwsIfContainsReservedKeyword() {
        List<String> names = List.of("neo", "all", "brie");
        assertThrows(IllegalArgumentException.class, () ->
                Participants.of(names));
    }
}
