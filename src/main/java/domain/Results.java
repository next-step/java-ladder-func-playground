package domain;

public class Results {
    private final Names results;

    public Results(String input) {
        this.results = new Names(input);
    }

    public int size() {
        return results.size();
    }

    public Names getResults() {
        return results;
    }
}
