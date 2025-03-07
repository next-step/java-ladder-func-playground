package model;

import java.util.*;
import java.util.stream.*;

public class ReservedPositionGenerator {
    private static final Random random = new Random();

    public static List<Set<Integer>> generate(int width, int height) {
        List<Set<Integer>> reserved = initializeReservedList(height);
        List<Integer> positions = createShuffledPositions(width);

        assignPositions(reserved, positions);
        System.out.println(reserved);
        return reserved;
    }

    private static List<Set<Integer>> initializeReservedList(int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> new HashSet<Integer>())
                .collect(Collectors.toList());
    }

    private static List<Integer> createShuffledPositions(int width) {
        List<Integer> positions = IntStream.range(0, width)
                .boxed()
                .collect(Collectors.toList());

        positions.add(random.nextInt(width));

        do {
            Collections.shuffle(positions, random);
        } while (isSequence(positions));

        return positions;
    }

    private static boolean isSequence(List<Integer> numbers) {
        return IntStream.range(0, numbers.size() - 1)
                .anyMatch(i -> numbers.get(i).equals(numbers.get(i + 1)));
    }



    private static void assignPositions(List<Set<Integer>> reserved, List<Integer> positions) {
        for (int i = 0; i < reserved.size(); i++) {
            reserved.get(i).add(positions.get(i));
        }
    }
}
