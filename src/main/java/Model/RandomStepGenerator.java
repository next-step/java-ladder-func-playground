// RandomStepGenerator.java (새 파일)
package Model;

import java.util.Random;

// '랜덤으로' 스텝을 생성하는 실제 부품
public class RandomStepGenerator implements BridgeStepGenerator {

    private final Random random;

    public RandomStepGenerator() {
        this.random = new Random();
    }

    @Override
    public BridgeStep generateStep() {
        if (random.nextBoolean()) {
            return BridgeStep.EXIST;
        }
        return BridgeStep.NONE;
    }
}
