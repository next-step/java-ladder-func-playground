package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points;

    public Line(){
        this(4);
    }

    public Line(int ladderWidth) {
        this.points = new ArrayList<>();
        for(int i=0; i<ladderWidth-1; i++){
            boolean randomValue = new Random().nextBoolean();
            addPointWithValidation(randomValue, i);
        }
    }

    private void addPointWithValidation(boolean pointValue, int position){
        //연속 연결 불가 규칙에 따라 point를 추가합니다.
        if(position > 0 && points.get(position-1)){
            points.add(false);
            return;
        }
        points.add(pointValue);
    }

    public List<Boolean> getPoints(){
        return points;
    }
}
