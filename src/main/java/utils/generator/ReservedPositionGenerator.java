package utils.generator;

import utils.RandomUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class ReservedPositionGenerator {
    public static List<Set<Integer>> generate(int width, int height) {
        List<Set<Integer>> reserved = initializeReservedPositions(height);
        applyRandomReservations(reserved, width, height);
        return reserved;
    }

    private static List<Set<Integer>> initializeReservedPositions(int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> new HashSet<Integer>())
                .collect(Collectors.toList());
    }

    private static void applyRandomReservations(List<Set<Integer>> reserved, int width, int height) {
        IntStream.range(0, width)
                .forEach(i -> reserved.get(RandomUtil.nextInt(height)).add(i));
    }
}
