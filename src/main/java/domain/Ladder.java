package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Boolean> rungs;

    private Ladder(List<Boolean> rungs) {
        this.rungs = new ArrayList<>(rungs);
    }

    public static Ladder from(List<Boolean> rungsStatus) {
        return new Ladder(rungsStatus);
    }

    public int getHeight() {
        return rungs.size();
    }

    public List<Boolean> getRungsStatus() {
        return Collections.unmodifiableList(rungs);
    }

    public boolean checkRungExistAt(int position) {
        return rungs.get(position);
    }
}
