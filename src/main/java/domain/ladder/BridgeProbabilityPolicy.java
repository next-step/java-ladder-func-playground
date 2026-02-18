package domain.ladder;

public enum BridgeProbabilityPolicy {

    LOW(0.2),
    NORMAL(0.35),
    HIGH(0.6),
    ;

    private final double rate;

    BridgeProbabilityPolicy(double rate) {
        this.rate = rate;
    }

    public double rate() {
        return rate;
    }
}
