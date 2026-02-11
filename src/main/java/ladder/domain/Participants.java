package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {

    private final List<Name> participants;

    private Participants(List<Name> participants) {
        validate(participants);
        this.participants = participants;
    }

    public static Participants from(List<String> names) {
        List<Name> nameList = names.stream()
            .map(Name::from)
            .collect(Collectors.toList());
        return new Participants(nameList);
    }

    private void validate(List<Name> participants) {
        if (participants.size() < 2) {
            throw new IllegalArgumentException("참여할 사람은 최소 2명 이상이어야 합니다.");
        }
        long distinctCount = participants.stream()
            .map(Name::toString)
            .distinct()
            .count();
        if (distinctCount != participants.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    public int size() {
        return participants.size();
    }

    public List<Name> getValues() {
        return participants;
    }

}
