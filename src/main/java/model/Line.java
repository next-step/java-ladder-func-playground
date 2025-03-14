package model;

import java.util.Collections;
import java.util.List;

import static model.LinkStatus.PRESENT;

public class Line {

    private final List<Link> links;

    public Line(LinksGenerator linksGenerator) {
        this.links = Collections.unmodifiableList(linksGenerator.generate());
    }

    public List<Link> getLinks() {
        return links;
    }

    public int getNextPoint(int point) {
        if (shouldMoveToLeft(point)) {
            return point - 1;
        }
        if (shouldMoveToRight(point)) {
            return point + 1;
        }

        return point;
    }

    private boolean shouldMoveToLeft(int point) {
        if (isFirstPoint(point)) {
            return false;
        }

        return isLeftLinkPresent(point);
    }

    private boolean shouldMoveToRight(int point) {
        if (isLastPoint(point)) {
            return false;
        }

        return isRightLinkPresent(point);
    }

    private boolean isFirstPoint(int point) {
        return point == 0;
    }

    private boolean isLastPoint(int point) {
        return point == links.size();
    }

    private boolean isLeftLinkPresent(int index) {
        Link leftLink = links.get(index - 1);

        return leftLink.getLinkstatus() == PRESENT;
    }

    private boolean isRightLinkPresent(int index) {
        Link rightLink = links.get(index);

        return rightLink.getLinkstatus() == PRESENT;
    }

}
