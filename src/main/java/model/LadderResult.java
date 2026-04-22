package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {
    Map<Integer,Integer> ladderResult=new HashMap<>();
    Map<String,String>ladderGameResult=new HashMap<>();

    int width;
    public LadderResult(int width, Ladder ladder,List<String>names,List<String>targets){
        this.width=width;
        initLadderResult();
        playLadder(ladder);
        stringLadderResult(names,targets);
    }


    public void initLadderResult(){
        for(int i=0;i<width+1;i++){
            ladderResult.put(i,i);
        }
    }

    public void playLadder(Ladder ladder){
        for(int i=0;i<width+1;i++){
            movePlayer(ladder,i);
        }
    }
    public void movePlayer(Ladder ladder,int playerStart){
        int current=playerStart;
        for(Line line:ladder.getLadder()){
            current=line.move(current);
        }
        ladderResult.put(playerStart,current);
    }

    public void stringLadderResult(List<String> names,List<String> targets){
        for(int i=0;i<width+1;i++){
            ladderGameResult.put(names.get(i),targets.get(i));
        }
    }

    public String getTargetLadderResult(String name){
        return ladderGameResult.get(name);
    }

}
