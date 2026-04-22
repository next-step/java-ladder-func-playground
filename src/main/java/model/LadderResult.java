package model;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {
    Map<Integer,Integer> ladderResult=new HashMap<>();
    int width;

    public LadderResult(int width, Ladder ladder){
        this.width=width;
        initLadderResult();
        for(int i=0;i<width+1;i++){
            playLadder(ladder,i);
        }
    }


    public void initLadderResult(){
        for(int i=0;i<width+1;i++){
            ladderResult.put(i,i);
        }
    }
    public void playLadder(Ladder ladder,int playerStart){
        int current=playerStart;
        for(Line line:ladder.getLadder()){
            current=line.move(current);
        }
        ladderResult.put(playerStart,current);
    }

    public Map<Integer,Integer> getLadderResult(){
        return ladderResult;
    }
}
