package domain;

public class Result {

    private final String result;
    private final int number;

    public Result(String result, int number) {
        this.result = result;
        this.number = number;
    }

    public String getResult() {
        return this.result;
    }

    public int getNumber() {
        return this.number;
    }
}
