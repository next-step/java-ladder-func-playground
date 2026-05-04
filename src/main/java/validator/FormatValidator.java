package validator;

import util.StringUtil;

import java.util.List;

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
    public static boolean validateTargetsCount(String input,int count){
        try{
            List<String> targets= StringUtil.splitByComma(input);
            return targets.size()== count;
        }catch (Exception e){
            return false;
        }
    }
}
