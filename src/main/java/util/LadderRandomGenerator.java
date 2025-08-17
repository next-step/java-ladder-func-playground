
package util;

import java.util.List;
import java.util.stream.Stream;

public class LadderRandomGenerator {

    public static boolean generateRandomBoolean() {
        return Math.random() < 0.5;
    }

    public static List<Boolean> generateRandomLine(int length) {
        return Stream.generate(LadderRandomGenerator::generateRandomBoolean)
                .limit(length)
                .toList();
    }
}
