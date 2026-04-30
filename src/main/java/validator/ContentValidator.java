package validator;

import java.util.List;

public class ContentValidator {
    private  static final int MAX_NAME_LENGTH=5;

    public static boolean validateNameList(List<String>names){
        return names.stream()
                .allMatch(name->name.length()<=MAX_NAME_LENGTH);
    }

    public static boolean validateGetTarget(String input,List<String> nameList){
        for(String name:nameList){
            if(input.equals(name)){
                return true;
            }
            if(input.equals("all")){
                return true;
            }
        }
        return false;
    }
}
