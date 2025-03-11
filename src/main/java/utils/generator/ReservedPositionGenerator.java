package utils.generator;

import utils.RandomUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReservedPositionGenerator {
    public static List<Set<Integer>> generate(int width, int height) {
        List<Set<Integer>> reserved = IntStream.range(0, height)
                .mapToObj(i -> new HashSet<Integer>())
                .collect(Collectors.toList());

        IntStream.range(0, width)
                .forEach(i -> reserved.get(RandomUtil.nextInt(height)).add(i));

        return reserved;
    }
}
