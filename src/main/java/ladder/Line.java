package ladder;

import strategy.LinkStrategy;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> points;

    public Line(Column columns, LinkStrategy strategy) {
        this.points = new ArrayList<>();
        generateLinks(columns, strategy);
    }

    private void generateLinks(Column columns, LinkStrategy strategy) {
        boolean prevLinked = false;
        for (int column = 0; column < columns.value() - 1; column++) {
            Link link = createLink(strategy, prevLinked);
            prevLinked = link.isLinked();
            points.add(link);
        }
    }

    private Link createLink(LinkStrategy strategy, boolean prevLinked) {
        Link link = new Link();
        if (!prevLinked && strategy.canLink()) {
            link.link();
        }
        return link;
    }

    public boolean isLinkedAt(int column) {
        return points.get(column).isLinked();
    }

    public void linkAt(int column) {
        points.get(column).link();
    }

    public void unlinkAt(int column) {
        points.get(column).unlink();
    }

    public List<Link> getLinks() {
        return List.copyOf(points);
    }



}




