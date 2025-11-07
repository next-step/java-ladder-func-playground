package ladder.generator;

import model.ladder.generator.ConnectionGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FakeConnectionGenerator implements ConnectionGenerator {

    private final Queue<Boolean> predefinedValues;

    public FakeConnectionGenerator(List<Boolean> values) {
        this.predefinedValues = new LinkedList<>(values);
    }

    @Override
    public boolean generate() {
        if (predefinedValues.isEmpty()) {
            throw new IllegalStateException("테스트용 값이 부족합니다.");
        }
        return predefinedValues.poll();
    }
}
