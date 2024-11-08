package model.player;

public class PlayerName {

   private final String name;

    private final static int MIN_NAME_LENGTH = 1;
    private final static int MAX_NAME_LENGTH = 5;

    public PlayerName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException
                    ("플레이어의 이름은 "+MIN_NAME_LENGTH+"자 이상, "+MAX_NAME_LENGTH+"자 이하여야 합니다.");
        }

        if (name.isBlank()){
            throw new IllegalArgumentException("참여자 이름은 비어있을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
