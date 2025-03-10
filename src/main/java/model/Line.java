package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static model.LinkStatus.PRESENT;
import static model.LinkStatus.UNDEFINED;

public class Line {
    private static final Random random = new Random();

    private final List<Link> links;

    public Line(int width) {
        int size = width - 1;
        List<Link> links = initializeLinks(size);
        setupLinks(links);

        this.links = List.copyOf(links);
    }

    public List<Link> getLinks() {
        return links;
    }

    private List<Link> initializeLinks(int size) {
        List<Link> links = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            links.add(Link.getUndefinedLink());
        }

        return links;
    }

    private void setupLinks(List<Link> links) {
        int index = getRandomStartIndex(links);

        while (containsUndefined(links)) {
            ConnectDecider connectDecider = ConnectDecider.getRandomConnectDecider();
            boolean connectable = isConnectable(index, links);

            links.set(index, Link.getDefinedLink(connectDecider, connectable));

            index = getNextIndex(index, links);
        }
    }

    private int getRandomStartIndex(List<Link> links) {
        return random.nextInt(links.size());
    }

    private boolean containsUndefined(List<Link> links) {
        return links.stream()
                .anyMatch(Link::isUndefined);
    }

    private boolean isConnectable(int index, List<Link> links) {
        if (isFirstIndex(index)) {
            return isRightNotPresent(index, links);
        }
        if (isLastIndex(index, links)) {
            return isLeftNotPresent(index, links);
        }

        return isRightNotPresent(index, links) && isLeftNotPresent(index, links);
    }

    private boolean isFirstIndex(int index) {
        return index == 0;
    }

    private boolean isLastIndex(int index, List<Link> links) {
        return index == links.size() - 1;
    }

    private boolean isRightNotPresent(int index, List<Link> links) {
        Link rightLink = links.get(index + 1);

        return rightLink.getLinkstatus() != PRESENT;
    }

    private boolean isLeftNotPresent(int index, List<Link> links) {
        Link leftLink = links.get(index - 1);

        return leftLink.getLinkstatus() != PRESENT;
    }

    private int getNextIndex(int index, List<Link> linkStatuses) {
        return (index + 1) % linkStatuses.size();
    }

}
