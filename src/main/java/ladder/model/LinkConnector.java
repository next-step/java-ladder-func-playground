package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkConnector {
    private static final Random random = new Random();

    public List<Boolean> generate(int width) {
        List<Boolean> links = new ArrayList<>();
        for (int i = 0; i < width - 1; i++) {
            links.add(decide(i, links));
        }
        return links;
    }

    private boolean decide(int index, List<Boolean> links) {
        if (index > 0 && links.get(index - 1)) {
            return false;
        }
        return random.nextBoolean();
    }
}
