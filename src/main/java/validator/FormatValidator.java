package validator;

public class FormatValidator {
    public static boolean validateCommaSeparatedFormat(String input) {
        if (input.isBlank()) {
            return false;
        }
        return input.matches("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$");
    }
    public static boolean validateIntegerFormat(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
