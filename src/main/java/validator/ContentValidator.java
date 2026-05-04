package validator;

import domain.ResultType;

import java.util.List;

public class ContentValidator {
    private  static final int MAX_NAME_LENGTH=5;

    public static boolean validateNameList(List<String>names){
        return names.stream()
                .allMatch(name->name.length()<=MAX_NAME_LENGTH);
    }

    public static boolean validateGetTarget(String input,List<String> nameList){
        if(ResultType.from(input).isAll()){
            return true;
        }
        return nameList.contains(input);
    }
}
