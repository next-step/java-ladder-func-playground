package util;

import java.util.Arrays;
import java.util.List;

import model.Person;

public class InputParser {

    public static int parseLadderHeight(String input) {
        LadderVaildator.validateLadderHeight(input);
        return Integer.parseInt(input);
    }

    public static int parseLadderWidth(String input) {
        LadderVaildator.validateLadderWidth(input);
        return Integer.parseInt(input);
    }

    public static List<Person> parsePersons(String input) {
        LadderVaildator.validatePersons(input);
        String[] names = input.split(",");
        return Person.fromNames(Arrays.asList(names));
    }

    public static List<String> parseResults(String input) {
        LadderVaildator.validateResults(input);
        return Arrays.asList(input.split(","));
    }
}
