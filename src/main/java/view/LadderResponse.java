package view;
import model.Ladder;

public class LadderResponse {

    // TODO: 필요한 필드 선언


    private LadderResponse() {
        // TODO : 필드에 해당하는 생성자 선언 (파라미터 포함)
    }

    public static LadderResponse from(final Ladder ladder) {
        // TODO : 정적 팩토리 메서드를 통해 사다리 객체 DTO 자동 생성
        return new LadderResponse();
    }
}
