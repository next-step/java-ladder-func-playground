package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkConnector {
    private static final Random random = new Random();

    public List<Boolean> generate(int width) {
        List<Boolean> links = new ArrayList<>(width - 1);
        boolean hasBridge = false;

        for (int i = 0; i < width - 1; i++) {
            boolean previousBridge = (i > 0 && links.get(i - 1));
            boolean currentBridge = (!previousBridge && random.nextBoolean());
            hasBridge = hasBridge || currentBridge;
            links.add(currentBridge);
        }
        if (!hasBridge && width - 1 > 0) {
            int j = random.nextInt(width - 1);
            links.set(j, true);
        }
        return links;
    }
}
