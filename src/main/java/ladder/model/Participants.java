package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Participants {

    private final List<Name> names;

    private Participants(List<Name> names) {
        this.names = names;
    }

    public static Participants of(List<Name> names) {
        return new Participants(new ArrayList<>(names));
    }

    public int size() {
        return names.size();
    }

    public List<Name> getParticipantsNameList() {
        return new ArrayList<>(names);
    }
}
