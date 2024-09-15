package domain;

import java.util.Set;

public interface AvailablePositionsFilter {

    void setAvailablePositionsExcluding(Set<Integer> excludedPositionsOfRung, int height);

}
