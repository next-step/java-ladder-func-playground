package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<String> names) {
        this.participants = IntStream.range(0, names.size())
                .mapToObj(i -> new Participant(names.get(i), i))
                .toList();
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
