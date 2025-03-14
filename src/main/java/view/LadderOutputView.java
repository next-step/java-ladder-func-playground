package view;

import dto.LadderResultDto;
import dto.LineDto;

import java.util.List;

public class LadderOutputView {

    private static final String LADDER_INDENTATION = "    ";
    private static final String VALUE_INDENTATION = "  ";
    private static final String DASH_COUPLER = "-----";
    private static final String BLANK_COUPLER = "     ";
    private static final String PILLAR = "|";
    private static final int MAX_FORMATTED_VALUE_LENGTH = 5;
    private static final String WHITE_SPACE = " ";

    private static final LadderOutputView ladderOutputView = new LadderOutputView();

    private LadderOutputView() {
    }

    public static LadderOutputView getInstance() {
        return ladderOutputView;
    }

    public void printLadderResultHeader() {
        System.out.println("사다리 결과");
        System.out.println();
    }

    public void printNames(List<String> names) {
        StringBuilder output = new StringBuilder(VALUE_INDENTATION);

        for (String name : names) {
            output.append(formatValue(name))
                    .append(WHITE_SPACE);
        }

        System.out.println(output);
    }

    public void printLine(LineDto lineDto) {
        StringBuilder output = new StringBuilder(LADDER_INDENTATION)
                .append(PILLAR);

        for (boolean isExist : lineDto.getLinkExistCollection()) {
            String coupler = getCoupler(isExist);
            output.append(coupler)
                    .append(PILLAR);
        }

        System.out.println(output);
    }

    public void printResultValues(String[] resultValues) {
        StringBuilder output = new StringBuilder(VALUE_INDENTATION);

        for (String resultValue : resultValues) {
            output.append(formatValue(resultValue))
                    .append(WHITE_SPACE);
        }

        System.out.println(output);
        System.out.println();
    }

    public void printLadderResult(String resultValue) {
        System.out.println("실행 결과");

        System.out.println(resultValue);

        System.out.println();
    }

    public void printLadderResults(List<LadderResultDto> ladderResultDtos) {
        System.out.println("실행 결과");

        for (LadderResultDto ladderResultDto : ladderResultDtos) {
            String name = ladderResultDto.name();
            String resultValue = ladderResultDto.resultValue();

            System.out.println(name + " : " + resultValue);
        }
    }

    private String getCoupler(boolean isLinkExist) {
        if (isLinkExist) {
            return DASH_COUPLER;
        }
        return BLANK_COUPLER;
    }

    private String formatValue(String value) {
        StringBuilder valueFormatter = new StringBuilder(value);

        boolean shouldPrepend = true;
        while (isShortThanMaxLength(valueFormatter)) {
            appendWhiteSpace(valueFormatter, shouldPrepend);
            shouldPrepend = toggle(shouldPrepend);
        }

        return valueFormatter.toString();
    }

    private boolean isShortThanMaxLength(StringBuilder value) {
        return value.length() < MAX_FORMATTED_VALUE_LENGTH;
    }

    private void appendWhiteSpace(StringBuilder stringBuilder, boolean shouldPrepend) {
        if (shouldPrepend) {
            stringBuilder.insert(0, WHITE_SPACE);
            return;
        }

        stringBuilder.append(WHITE_SPACE);
    }

    private boolean toggle(boolean value) {
        return !value;
    }

}
