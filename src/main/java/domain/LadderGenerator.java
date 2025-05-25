package domain;
import java.util.*;
import java.util.stream.Collectors;

public class LadderGenerator {
    public static Ladder generate(int countOfPlayers, Height height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(Line.generate(countOfPlayers));
        }
        return new Ladder(lines);
    }
}
