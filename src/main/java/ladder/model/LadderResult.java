package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {

    private final Participants participants;
    private final List<Result> results;

    public LadderResult(Participants participants, List<Result> results) {
        this.participants = participants;
        this.results = results;
    }

    public List<Result> getAll() {
        return new ArrayList<>(results);
    }

    public List<Name> getParticipants() {
        return participants.getParticipantsNameList();
    }

    public Result getResult(String participant) {
        return participants.getParticipantsNameList().stream()
            .filter(name -> name.matches(participant))
            .findFirst()
            .map(name -> results.get(participants.getParticipantsNameList().indexOf(name)))
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자입니다."));
    }
}
