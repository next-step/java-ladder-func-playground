package strategy;

public interface LinkStrategy {
    boolean canLink();

    int pickRow(int bound);
}
