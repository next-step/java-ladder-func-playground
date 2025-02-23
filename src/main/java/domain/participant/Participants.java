package domain.participant;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<String> names) {
        validateDuplicateName(names);
        this.participants = IntStream.range(0, names.size())
                .mapToObj(i -> new Participant(names.get(i), i))
                .toList();
    }

    private void validateDuplicateName(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException("모두 다른 이름을 작성해주세요.");
        }
    }

    public int getParticipantCount() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public Participant getParticipant(String name) {
        Integer index = participants.stream()
                .filter(p -> p.getName().equals(name))
                .map(Participant::getStartPoint)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 참가자가 존재하지 않습니다."));

        return participants.get(index);
    }
}
