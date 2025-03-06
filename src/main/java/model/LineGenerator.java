package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    public List<Boolean> createRandomBoolean(int width) {
        Random random = new Random();
        List<Boolean> booleans= new ArrayList<>();

        for (int i = 0; i < width-1; i++) {
            booleans.add(random.nextBoolean());
        }

        return booleans;
    }
}
