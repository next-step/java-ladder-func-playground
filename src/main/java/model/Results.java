package model;

import java.util.List;

public class Results {

    private final List<String> resultValues;

    public Results(List<String> resultValues) {
        this.resultValues = resultValues;
    }

    public String getResultByIndex(Integer index) {
        if (index < 0 || index >= resultValues.size()) {
            throw new IndexOutOfBoundsException("유효하지 않은 결과 인덱스입니다.");
        }
        return resultValues.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String resultValue : resultValues) {
            stringBuilder.append(resultValue);
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();
    }
}
