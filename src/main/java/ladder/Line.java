package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Link> points;

    public Line(int column) {
        this.points = new ArrayList<>();
        for (int i = 0; i < column - 1; i++) { //한 열 빼주기
            points.add(new Link());
        }
    }

    public void randomlyLink(Random random) {
        //랜덤으로 연결시켜줌
        for (int i = 0; i < points.size(); i++) {
            if (cannotLink(i)) {
                continue;
            }

            conditionallyLink(i, random);
        }
    }

    private boolean cannotLink(int index) {
        // 이전 위치가 이미 연결되어 있다면 현재는 연결할 수 없음
        return index > 0 && points.get(index - 1).isLinked();
    }

    private void conditionallyLink(int index, Random random) {
        // 랜덤 조건에 따라 현재 위치를 링크
        if (random.nextBoolean()) {
            points.get(index).link();
        }
    }

    public List<Link> getLinks() {
        return List.copyOf(points);
    }

}




