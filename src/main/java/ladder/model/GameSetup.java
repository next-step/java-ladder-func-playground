package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class GameSetup {

    private final Participants participants;
    private final List<String> results;
    private final Ladder ladder;

    public GameSetup(Participants participants, List<String> results, Ladder ladder) {
        this.participants = participants;
        this.results = new ArrayList<>(results);
        this.ladder = ladder;
    }

    public Participants getParticipants() {
        return participants;
    }

    public List<String> getResults() {
        return new ArrayList<>(results);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
