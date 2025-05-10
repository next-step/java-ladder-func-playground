package domain.prize;

import java.util.List;

public class PrizeNames {

    private final List<PrizeName> prizeNames;

    public PrizeNames(List<PrizeName> prizeNames) {
        this.prizeNames = List.copyOf(prizeNames);
    }

    public int size() {
        return prizeNames.size();
    }

    public PrizeName get(int index) {
        return prizeNames.get(index);
    }

    public List<PrizeName> getAll() {
        return prizeNames;
    }

    public PrizeName getByIndex(int index) {
        return prizeNames.get(index);
    }

}
