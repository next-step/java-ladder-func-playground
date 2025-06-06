package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final Participants participants;
    private final List<String> results;

    public Results(Participants participants, List<String> results) {
        this.participants = participants;
        this.results = results;
    }

    public List<String> getAll() {
        return new ArrayList<>(results);
    }

    public List<Name> getParticipants() {
        return participants.values();
    }

    public String getResult(String participant) {
        return participants.values().stream()
            .filter(name -> name.matches(participant))
            .findFirst()
            .map(name -> results.get(participants.values().indexOf(name)))
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자입니다."));
    }
}
