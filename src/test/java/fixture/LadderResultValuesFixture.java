package fixture;

import java.util.Arrays;

public enum LadderResultValuesFixture {

    FOUR_RESULTS(new String[]{"result1", "result2", "result3", "result4"}),
    FIVE_RESULTS(new String[]{"resultA", "resultB", "resultC", "resultD", "resultE"});

    private final String[] resultValues;

    LadderResultValuesFixture(String[] resultValues) {
        this.resultValues = resultValues;
    }

    public String[] getValue() {
        return Arrays.copyOf(resultValues, resultValues.length);
    }

}
