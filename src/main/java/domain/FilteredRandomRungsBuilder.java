package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilteredRandomRungsBuilder implements RungsBuilder, AvailablePositionsFilter {

    private static final Random random = new Random();
    private List<Integer> availablePositionsOfRung;


    @Override
    public int getPositionOfRung() {
        int randomIndex = random.nextInt(availablePositionsOfRung.size());
        return availablePositionsOfRung.get(randomIndex);
    }

    @Override
    public Set<Integer> getPositionsOfRungs() {
        Set<Integer> positionsOfRungs = new HashSet<>();
        for (Integer candidate : availablePositionsOfRung) {
            if (random.nextBoolean()) {
                positionsOfRungs.add(candidate);
            }
        }
        return positionsOfRungs;
    }

    @Override
    public void setAvailablePositionsExcluding(Set<Integer> excludedPositionsOfRung, int height) {
        this.availablePositionsOfRung = IntStream.range(0, height)
            .filter(num -> !excludedPositionsOfRung.contains(num))
            .boxed()
            .collect(Collectors.toList());
    }
}
