package model.tool;

public class Splitter {
    final static private String SPLIT_SIGN = ",";

    public String[] splitWithComma(String beforeSplit) {
        String[] afterSplit = beforeSplit.split(SPLIT_SIGN);
        for (int i = 0; i < afterSplit.length; i++) {
            afterSplit[i] = afterSplit[i].trim();
        }
        return afterSplit;
    }
}
