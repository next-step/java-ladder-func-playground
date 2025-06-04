package strategy;

import generator.Generator;

import java.util.Random;

public class RandomLinkStrategy implements LinkStrategy{
    private final Generator generator;

    public RandomLinkStrategy(Generator generator) {
        this.generator = generator;
    }

    @Override
    public boolean canLink() {
        return generator.getRandomBoolean();
    }

    @Override
    public int pickRow(int bound) {
        return generator.getRandomInt(bound);
    }
}
