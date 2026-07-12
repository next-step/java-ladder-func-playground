package util;

import java.util.ArrayList;
import java.util.List;

public class TextUtils {

    private static final String SPLIT_CHARACTERS = ",";

    public static List<String> splitMessageWithComma(final String message) {
        return new ArrayList<String>(List.of(message.split(SPLIT_CHARACTERS)));
    }
}
