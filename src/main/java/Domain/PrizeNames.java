package Domain;

import java.util.List;

public class PrizeNames {

    private final List<PrizeName> prizeNames;

    public PrizeNames(List<PrizeName> prizeNames) {
        this.prizeNames = List.copyOf(prizeNames);
    }

    public PrizeName get(int index) {
        return prizeNames.get(index);
    }

    public List<PrizeName> getAll() {
        return prizeNames;
    }
}
