package validator;

public class Validator {
    private  static final int MAX_NAME_LENGTH=5;

    public static void validateCommaSeparatedFormat(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("ERROR: 입력 값이 비어 있습니다.");
        }
        if(!input.matches("^[^,]+(,[^,]+)*$")){
            throw new IllegalArgumentException("ERROR: 이름은 쉼표(,)로만 구분해야 합니다.");
        }
    }

    public static void validateSingleName(String name){
        if(name.isBlank()){
            throw new IllegalArgumentException("ERROR: 비어있는 이름이 존재합니다.");
        }
        if(name.length()>MAX_NAME_LENGTH){
            throw new IllegalArgumentException("ERROR: 이름은 최대 5글자까지 가능합니다.");
        }
    }

    public static void validateInteger(String input){
        if(input.isBlank()){
            throw new IllegalArgumentException("ERROR: 입력 값이 비어 있습니다.");
        }
        try{
            Integer.parseInt(input.trim());
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("ERROR: 숫자만을 입력해야 합니다.");
        }
    }
}
